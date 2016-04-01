package it.polito.tdp.rubrica.model;

import java.util.*;

/** 
 * Rappresenta l'insieme di tutte le voci della rubrica
 * e i metodi per gestire tale insieme
 * @author LUCA
 *
 */
public class RubricaModel {

	private List <VoceRubrica> rubrica;
	
	public RubricaModel(){
		this.rubrica= new ArrayList<VoceRubrica>();
	}
	
	/** 
	 * Aggiunge una nuova voce alla rubrica,se questa
	 * non esiste ancora. Se invece esiste segnala 
	 * l'errore restituendo {@code false}
	 * @param v la nuova voce da aggiungere
	 * @return {@code true } se la voce è stata aggiunta correttamente,
	 * {@code false } se esisteva già e quindi non viene aggiunta
	 */
	public boolean addVoce(VoceRubrica v)
	{
		if(rubrica.contains(v))
			return false;
		else{
			rubrica.add(v);
			return true;
			}
		
	}
	
	/** ricerca nell'intera rubrica una {@link VoceRubrica} che abbia
	 * il nome uguale a quello specificato. Se esiste ritorna tale oggetto
	 * altrimenti ritorna null
	 * @param nome il nome da ricercare
	 * @return
	 */
	public VoceRubrica findVoceByNome(String nome)
	{
		for(VoceRubrica v : rubrica)
		{
			if(v.getNome().equals(nome))
				return v;
		}
		return null;
	}
	
	
	public List<VoceRubrica> getRubrica() {
		return rubrica;
	}

	public static void main(String [] args)
	{
		RubricaModel m = new RubricaModel();
		boolean r1 = m.addVoce(new VoceRubrica("Fulvio","fulvio.corno@polito.it","7053"));
		boolean r2 = m.addVoce(new VoceRubrica("Giovanni","giovanni.squillero@polito.it","7077"));
		boolean r3 = m.addVoce(new VoceRubrica("Fulvio","f.qualcunaltro@polito.it","7059"));
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		
		VoceRubrica v1 = m.findVoceByNome("Giovanni");
		VoceRubrica v2 = m.findVoceByNome("Piero");
		System.out.println(v1);
		System.out.println(v2);



	}
	
}
