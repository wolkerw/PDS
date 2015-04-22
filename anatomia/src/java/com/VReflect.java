package com;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public final class VReflect{
	
	Object pObjeto =  null;
	java.lang.Class pClasse = null;
	
	public VReflect(){
	}

	public Object getObjeto(){
		return pObjeto;
	}
	
	public VReflect( String strClasse ) throws Exception{
//		defino a classe que desejo criar
        pClasse = Class.forName(strClasse);
        
        //instancio a classe
        pObjeto = pClasse.newInstance();		
	}
	
	public String executaMetodo(String metodo, Object parametros[] ) throws Exception, Throwable{		
		Class tipoparametros[] = null;	
	
		if (parametros != null){
			tipoparametros = new Class[parametros.length];
			for(int i=0; i < parametros.length; i++){
				tipoparametros[i] = parametros[i].getClass(); 
			}
		}		
		
		try {
			Object objLocal = pClasse.getMethod(metodo.trim(),tipoparametros).invoke(pObjeto,parametros);
			
			if (objLocal == null){					
				return ""; 		
			}else{
				return objLocal.toString();
			}
			
		} catch (InvocationTargetException e) {			
			throw e.getTargetException();
		} catch (Exception e) {						
			if (e.getMessage()==null){
				if (e.getCause()==null){
					System.out.print( "Sem causa " );
					throw new Exception("Ocorreu um erro ao executar metodo: "+metodo+". A mensagem de erro retornou valor nulo.");
				}else{
					Exception le = new Exception( e.getMessage() );
					le.setStackTrace( e.getStackTrace() );
					throw  le;					
				}	
			}else{
				System.out.print( " Mensagem "+e.getMessage() );
				throw e;
			}
		}		
		
		

	}
	
	public Object executaMetodo(String classe, String metodo, Object parametros[] ) throws Exception{		
		try{
			pClasse = Class.forName(classe);		
			pObjeto = pClasse.newInstance();
			metodo=metodo.replaceAll("\\(\\)","");
			
			System.out.println(classe +  " - "  + metodo);
			return executaMetodo(pObjeto,metodo,parametros);
		} catch (InvocationTargetException e) {			
			throw new Exception(e.getTargetException());
		}	
	}
	
	public Object executaMetodo(Object objetoParam, String metodo, Object parametros[]) throws Exception {
        try {
            boolean achou = true;
            Object objRetorno = null;

            for (int i = 0; i < objetoParam.getClass().getMethods().length; i++) {

                if (objetoParam.getClass().getMethods()[i].getName().equals(metodo.trim())) {
                    Class tipoparametros[] = objetoParam.getClass().getMethods()[i].getParameterTypes();
                    achou = (parametros == null ? 0 : parametros.length) == tipoparametros.length;

                    if (tipoparametros.length > 0) {
                        if (achou) {
                            for (int j = 0; j < parametros.length; j++) {

                                Class classe = parametros[j].getClass();
                                
                                while (classe != null && !classe.getName().equals(tipoparametros[j].getName())) {
                                    classe = classe.getSuperclass();
                                }

                                if (classe == null) {
                                    achou = false;
                                }
                            }
                        }
                    }

                    if (achou) {
                        objRetorno = objetoParam.getClass().getMethods()[i].invoke(objetoParam, parametros);
                        break;
                    }
                }
            }

            if (!achou) {
                throw new Exception("Método de mesmo tipo nao encontrado");
            }

            return objRetorno;
        } catch (InvocationTargetException e) {
            throw new Exception(e.getTargetException());
        }
    }
	
    public static String getValorMetodo(String strClasse, String campo, String filtro) throws Exception{
        int i, iMetodo;
        String retorno = "";
        Utilitario oUtl = new Utilitario();
        //parametros que vou passar ao metodo da classe dinamica
        Object parametros[] = {new String("")};
        String vetMetodos[];
        Object retornoParcial;
        
        java.lang.Class classe = null;
        
        // declaro o objeto
        Object objeto = null;
        
        try{

            vetMetodos = campo.split("[.]");

            parametros[0] = filtro;
        
            //defino a classe que desejo criar
            classe = Class.forName(strClasse);
            
            //instancio a classe
            objeto = classe.newInstance();

            for (i=0; i<classe.getMethods().length;i++){
                //até encontrar o método
                if (classe.getMethods()[i].getName().equalsIgnoreCase("setFiltroIntervalo")){
                    //executa o método por reflection no caso invoque
                    //preste atenção que passo os parametros no segundo argumento
                    //os parametros são um array de objetos
                    classe.getMethods()[i].invoke(objeto,parametros);
                }
            }
 
            classe.getMethod("lista",null).invoke(objeto,null);
            classe.getMethod("next",null).invoke(objeto,null);

            //varrendo os métodos da classe
            for (iMetodo=0;iMetodo<vetMetodos.length;iMetodo++){
                for (i=0; i<classe.getMethods().length;i++){
                    //até encontrar o método
                    vetMetodos[iMetodo]=vetMetodos[iMetodo].replaceAll("[)]","");
                    vetMetodos[iMetodo]=vetMetodos[iMetodo].replaceAll("[(]","");
                    if (classe.getMethods()[i].getName().equalsIgnoreCase(vetMetodos[iMetodo])){
                        //executa o método por reflection no caso invoque
                        //preste atenção que passo os parametros no segundo argumento
                        //os parametros são um array de objetos
                        if (iMetodo!=vetMetodos.length-1){
                            objeto = classe.getMethods()[i].invoke(objeto,null);
                            classe = objeto.getClass();
                            break;
                        }else{
                        	Object objRetorno = classe.getMethods()[i].invoke(objeto,null);

                        	if (objRetorno==null){
                            	throw new Exception( "Não encontrado" );
                            }else{
                            	retorno = objRetorno.toString();
                            }
                        }
                    }
                }
            }
            classe.getMethod("desconecta",null).invoke(objeto,null);
            

		} catch (InvocationTargetException e) {			
			
			try{
				classe.getMethod("desconecta",null).invoke(objeto,null);
			}catch (Exception ex) {}
			
			throw new Exception(e.getTargetException());
        }catch (Exception e){

			try{
				classe.getMethod("desconecta",null).invoke(objeto,null);
			}catch (Exception ex) {}

        	throw e;
        }

        return retorno;
    }   
    
    public static List getMetodosClasse(String strClasse){
        ArrayList arrRetorno = new ArrayList();
        
    	java.lang.Class classe = null;
        
        Object objeto = null;
        try{
            //defino a classe que desejo criar
            classe = Class.forName(strClasse);
            
            //instancio a classe
            objeto = classe.newInstance();

            for (int i=0; i<classe.getDeclaredMethods().length;i++){
            	arrRetorno.add(classe.getDeclaredMethods()[i].getName());
            }
        }catch (Exception e) {
        	e.printStackTrace();
		}
        return arrRetorno;
    }
    public static void main(String[] args){
		System.out.println( VReflect.getMetodosClasse("com.virtuallis.ST_Intab") );
	}       
}