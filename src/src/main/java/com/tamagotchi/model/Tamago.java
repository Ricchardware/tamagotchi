package com.tamagotchi.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Tamago  {
	
	int fame, sonno, pulizia, felicita;
	
	//int timeSpent   int evol. TipoEvoluzione. ...

//  =========
	public void nutri() {
		
		int dif = fame - 5;
		int diff = pulizia - 1;

		fame = diffCheck(dif);	
		pulizia = diffCheck(diff);
		
	}
	public void passeggia() {

		int sum = felicita + 3;
		int summ = sonno + 2;
		int diff = pulizia - 1;
				
		felicita = sumCheck(sum);
		sonno = sumCheck(summ);
		pulizia = diffCheck(diff);
			
	}
	public void pulisci() {pulizia = 10;}
	public void accarezza() {
		
		int sum = felicita + 5;	
		felicita = sumCheck(sum);
	
	}

	public String checkStato() {
		StringBuilder sb = new StringBuilder();

		sb.append("Il tuo Tamago:"+'\n');
		
		sb.append(checkEnergia(sonno));
		sb.append(checkFame(fame));
		sb.append(checkPulizia(pulizia));
		sb.append(checkFelicita(felicita));
		
		return sb.toString();
	}
	
	public void spendTime() {
		//if timeSpent > ... evol...
		int sum = fame + 2;
		int summ = sonno + 1;
		int dif = pulizia - 1;
		
		fame = sumCheck(sum);
		sonno = sumCheck(summ) == 10? 0 : sumCheck(summ);
		pulizia = diffCheck(dif);
		
		if(fame >= 7)
			felicita = diffCheck(felicita - 1);
		
		if(pulizia<= 3)
			felicita = diffCheck(felicita - 1);
		
	}
//  =========
	
//  =========
	private int diffCheck(int n) {return n<0? 0 : n;}
	private int sumCheck(int n) {return n> 10? 10 : n;}
	
	private String checkEnergia(int ener) {
		
		String str = null;
		
		switch (ener) {						
		case 10:
			str = "Sta dormendo...";
			break;
			
		case 9:			
		case 8:
			str = "È molto stanco!";
			break;
			
		default:
			str = "Non è ancora stanco.";
		}
		
		return str;
		
	}
	private String checkFame(int f) {return f>=7? "È affamato!" : "Non ha molta fame";}
	private String checkPulizia(int puli) {return puli<= 3? "È sporco!" : "È pulito";}
	private String checkFelicita(int happy) {
		
		String str = null;
		
		switch (happy) {
		case 10:
		case 9:
		case 8:
		case 7:
			str= "È felice";
			break;

		case 6:
		case 5:
		case 4:		
			str = "È OK...";
			break;
			
		default:
			str= "È triste";
		}
		
		return str;
		
	}
//  =========
	
}