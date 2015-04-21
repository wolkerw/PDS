package com;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;


public class HC_Msys_tabela extends Msys_tabela {

    public HC_Msys_tabela() {
    }

    /**
     * Insere tabelas do banco de dados em msys_tabela  
     * @throws Exception
     */
    public void geraTabelas() throws Exception {

        System.out.println("Obtendo tabelas...");
        long time = System.currentTimeMillis();

        Connection conn = getConnexao();

        ResultSet rsTabelas = conn.getMetaData().getTables(null, null, null, new String[] { "TABLE" });

        while (rsTabelas.next()) {

            String nomeTabela = rsTabelas.getString("TABLE_NAME");

            StringBuilder sbSql = new StringBuilder();
            sbSql.append(" SELECT 1 \n ");
            sbSql.append(" FROM msys_tabela ");
            sbSql.append(" WHERE nome_tabela = ");
            sbSql.append(" '" + nomeTabela + "' ");

            ResultSet rs = conn.createStatement().executeQuery(sbSql.toString());
            if ( !rs.next() ){
                insereRegistro(conn, nomeTabela);
            }
        }

        System.out.println("Tabelas setadas. (" + (System.currentTimeMillis() - time) / 1000 + "s)");

        System.out.println("Obtendo tipo das PKs...");
        time = System.currentTimeMillis();

        ResultSet rs = conn.createStatement().executeQuery("SELECT cod_tabela, nome_tabela, flag_tipochave FROM msys_tabela");

        while (rs.next()) {

            String nomeTabela = rs.getString("nome_tabela");
            String tipoChave = rs.getString("flag_tipochave");

            if (tipoChave == null) {

                String flagTipo = "X";

                ResultSet rsPks = conn.getMetaData().getPrimaryKeys(null, null, nomeTabela);

                while (rsPks.next()) {

                    String nomeColuna = rsPks.getString("COLUMN_NAME");

                    ResultSet rsCol = conn.getMetaData().getColumns(null, null, nomeTabela, nomeColuna);

                    while (rsCol.next()) {

                        int tipo = rsCol.getInt("DATA_TYPE");

                        if (java.sql.Types.CHAR == tipo || java.sql.Types.VARCHAR == tipo || java.sql.Types.LONGNVARCHAR == tipo
                                || java.sql.Types.NVARCHAR == tipo || java.sql.Types.LONGVARCHAR == tipo || java.sql.Types.NCHAR == tipo) {

                            flagTipo = "T";
                        } else
                            flagTipo = "N";
                    }
                }

                conn.createStatement().executeUpdate(
                        "UPDATE msys_tabela SET flag_tipochave = '" + flagTipo + "' WHERE cod_tabela = " + rs.getString("cod_tabela"));
            }
        }

        System.out.println("Tipo das PKs setado. (" + (System.currentTimeMillis() - time) / 1000 + "s)");

    }

    private static  int  insereRegistro(Connection conn, String nomeTabela) throws Exception {
        StringBuilder sbSql = new StringBuilder();
        sbSql.append(" SELECT max(cod_tabela) as cod_tabela \n ");
        sbSql.append(" FROM msys_tabela ");

        int codTabela = 0;
        ResultSet rsMax = conn.createStatement().executeQuery(sbSql.toString());
        if ( rsMax.next() ){
            codTabela = rsMax.getInt("cod_tabela");
        }
        codTabela++;

        conn.createStatement().executeUpdate(
                "INSERT INTO msys_tabela (cod_tabela, nome_tabela, seq_livre, inf_tabela, val_incremento, desc_titulo, flag_tipochave) VALUES ("+codTabela+", '"
                + nomeTabela + "', 0, 'Gerado pelo gerenciador de ID', 1, '', NULL)");
        
        return codTabela;
    }

    public static long acertaMsysTabela(Connection conn, int codTabela) throws Exception {

        long seqLivre = 0;

        DatabaseMetaData dbmd = conn.getMetaData();

        Msys_tabela oMT = new Msys_tabela();
        oMT.setConnexao(conn);
        oMT.setInTransaction(true);
        oMT.setCodtabela(codTabela);
        oMT.lista();

        while (oMT.next()) {

            HashSet<String> hsPk = new HashSet<String>();

            ResultSet rsPK = dbmd.getPrimaryKeys(null, null, oMT.getRsNometabela().toLowerCase());

            while (rsPK.next())
                hsPk.add(rsPK.getString("COLUMN_NAME"));

            String strColPk = "";

            for (Iterator<String> iter = hsPk.iterator(); iter.hasNext();)
                strColPk = (String) iter.next();

            hsPk.clear();

            if (!strColPk.equals("")) {

                seqLivre = obtemUltPKTabela(conn, oMT.getRsNometabela(), strColPk) + oMT.getRsValincremento();

                HC_Msys_tabela oMTupd = new HC_Msys_tabela();
                oMTupd.setConnexao(conn);
                oMTupd.setInTransaction(true);
                oMTupd.setCodtabela(oMT.getRsCodtabela());
                oMTupd.setSeqlivre(seqLivre);
                oMTupd.setNometabela(oMT.getRsNometabela().toLowerCase());
                oMTupd.update();
            }
        }

        return seqLivre;
    }

    private static long obtemUltPKTabela(Connection objConn, String tabela, String coluna) throws Exception{
        //System.out.println("obtemUltPKTabela: "+tabela);

        Statement statement;
        ResultSet rsPK;
        String strWhere = "";
        String strSQL = new String("SELECT max(" + coluna + ") as proxID FROM " + tabela);

        long retorno=0;

        if (strWhere.trim().compareTo("")!=0){

            strSQL = strSQL + " WHERE " + strWhere;
        }


        try {
            statement = objConn.createStatement();

            rsPK = statement.executeQuery( DBSettings.trataLike(strSQL+" ") );
        } catch (Exception e) {
            System.out.println(strSQL);
            throw e;
        }
        rsPK.next();
        try{

            retorno = (rsPK.getLong("proxID"));
            if (rsPK.wasNull()){
                retorno=0;
            }
        } catch (Exception e){
            retorno = 0;
        }

        return retorno;
    }

    public long getProxId(String tabela) throws Exception{
        long retorno=0;
        long lSeqLivre=0;

        Connection objConn = null;
        try{
            objConn = getConnexao();

            HC_Msys_tabela oTabela = new HC_Msys_tabela();
            oTabela.setConnexao(objConn);
            oTabela.setInTransaction(true);

            HC_Msys_tabela oTabelaUpd = new HC_Msys_tabela();
            oTabelaUpd.setConnexao(objConn);
            oTabelaUpd.setInTransaction(true);

            StringBuilder sbSql = new StringBuilder();
            sbSql.append(" SELECT cod_tabela \n ");
            sbSql.append(" FROM msys_tabela ");
            sbSql.append(" WHERE nome_tabela = ");
            sbSql.append(" '" + tabela.toLowerCase() + "' ");
            
            Integer objCodTabela = null; 
            ResultSet rs = objConn.createStatement().executeQuery(sbSql.toString());
            if ( rs.next() ){
                objCodTabela = rs.getInt("cod_tabela");
            }
            
            if ( objCodTabela == null ){
                objCodTabela = insereRegistro( objConn, tabela );
                HC_Msys_tabela.acertaMsysTabela(objConn, objCodTabela.intValue());
            }


            oTabela.limpaPropriedades();
            if (DBSettings.getTipoBanco() == DBSettings.TIPO_POSTGRES ){
                oTabela.setTop(" 1 FOR UPDATE ");
            }
            oTabela.setCodtabela( objCodTabela.intValue() );
            oTabela.lista();
            if (!oTabela.next()){
                throw new Exception("Impossivel tratar Id automático para a tabela [" + tabela + "], por favor verifique tratamento das chaves primarias.");
            }

            oTabela.limpaPropriedades();
            oTabela.setCodtabela( oTabela.getRsCodtabela().intValue() );
            oTabela.setDesctitulo( oTabela.getRsDesctitulo() );
            oTabela.update(); // Tranca o registro

            oTabela.limpaPropriedades();
            oTabela.setCodtabela( oTabela.getRsCodtabela().intValue() );
            oTabela.lista();
            oTabela.next(); // Obtem o registro atualizado depois do lock

            oTabelaUpd.setCodtabela(oTabela.getRsCodtabela().intValue());
            if ( oTabela.getRsSeqlivre().intValue() == 0 ){
                lSeqLivre = acertaMsysTabela(objConn, objCodTabela.intValue());         
            }else{
                lSeqLivre = oTabela.getRsSeqlivre().longValue()+oTabela.getRsValincremento().intValue();
            }
            retorno=lSeqLivre;

            oTabelaUpd.setSeqlivre(lSeqLivre);
            oTabelaUpd.update();

        }catch (Exception e) {
            throw e;
        }

        return retorno;
    }

    public String getTipoPKTabela(String nomeTabela) {
        try{
            ResultSet rs = getConnexao().createStatement().executeQuery("SELECT flag_tipochave FROM msys_tabela WHERE nome_tabela = "+nomeTabela);
            while (rs.next()) {
                String tipoChave = rs.getString("flag_tipochave");
                if (tipoChave != null) {
                    return tipoChave; 
                }
            }            
        }catch (Exception e) {
        }
        return "N"; 
    }

    
    public String getRsNometabela() {
        return (super.getRsNometabela() == null ? null : super.getRsNometabela().toLowerCase());
    }

    public String getNometabela() {
        return (super.getNometabela() == null ? null : super.getNometabela().toLowerCase());
    }

    public void setNometabela(String valor) throws Exception {

        if (valor == null)
            super.setNometabela(null);
        else
            super.setNometabela(valor.toLowerCase());
    }

}

