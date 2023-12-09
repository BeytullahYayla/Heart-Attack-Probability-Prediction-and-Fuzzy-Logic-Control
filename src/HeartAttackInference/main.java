package HeartAttackInference;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;


import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class main {

	public static void main(String[] args) {
		Scanner	in= new Scanner(System.in);
		System.out.print("Sleep Duration:[0-12]: ");
		double sleepDuration=in.nextDouble();
		System.out.print("Eaten Fatty Food In Month:[0-30]: ");
		double eatenFattyFoodInMonth=in.nextDouble();
		try {
			HeartAttack heartAttack=new HeartAttack(sleepDuration, eatenFattyFoodInMonth);
			System.out.println(heartAttack);
			System.out.println();
			List<Rule> rules=heartAttack.getModel().getFunctionBlock("HeartAttack").getFuzzyRuleBlock("ruleBlock1").getRules();
			System.out.println("-------------- Executed Rules ---------------- \n");
			for(Rule rule:rules) {
				if(rule.getDegreeOfSupport()>0) {
					System.out.println(rule);
				}
				
			}
			FIS fis= heartAttack.getModel();
			//JFuzzyChart.get().chart(fis);
			JFuzzyChart.get().chart(fis.getVariable("heartAttackProbability").getDefuzzifier(),"HeartAttackProbability",true);
		}
		catch(URISyntaxException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
