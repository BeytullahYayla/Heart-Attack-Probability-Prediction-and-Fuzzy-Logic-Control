package HeartAttackInference;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class HeartAttack {
	
	private FIS fis;
	private double sleepDuration;
	private double eatenFattyFoodInMonth;
	
	public HeartAttack(double sleepDuration, double eatenFattyFoodInMonth) throws URISyntaxException {
		this.sleepDuration=sleepDuration;
		this.eatenFattyFoodInMonth=eatenFattyFoodInMonth;
		
		File file=new File(getClass().getResource("HeartAttack.fcl").toURI());
		fis=FIS.load(file.getPath(),true);
		fis.setVariable("sleepDuration", sleepDuration);
		fis.setVariable("eatenFattyFood", eatenFattyFoodInMonth);
		fis.evaluate();
	}
	public FIS getModel() {
		return fis;
	}
	@Override
	public String toString() {
		return "Sleep Duration:"+Math.round(fis.getVariable("sleepDuration").getValue())+" hour"+"\n"+"Eaten Fatty Food In Month:"+Math.round(fis.getVariable("eatenFattyFood").getValue())
		+" day"+"\n"+"Heart Attack Possibility:"+Math.round(fis.getVariable("heartAttackProbability").getValue());
	}
	

}
