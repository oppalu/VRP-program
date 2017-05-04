package examples;
/* --------------------------------------------------------------------------
 * MIPex1.java - Entering and optimizing a MIP problem
 */

import ilog.concert.*;
import ilog.cplex.*;


public class MIPex1 {
   public static void main(String[] args) {
      try {
         IloCplex cplex = new IloCplex();
 
         IloNumVar[][] var = new IloNumVar[1][];
         IloRange[][]  rng = new IloRange[1][];
 
         populateByRow(cplex, var, rng);
 
         if ( cplex.solve() ) {
            double[] x     = cplex.getValues(var[0]);
            double[] slack = cplex.getSlacks(rng[0]);

            System.out.println("Solution status = " + cplex.getStatus());
            System.out.println("Solution value  = " + cplex.getObjValue());

            for (int j = 0; j < x.length; ++j) {
               System.out.println("Variable " + j + ": Value = " + x[j]);
            }

            for (int i = 0; i < slack.length; ++i) {
               System.out.println("Constraint " + i + ": Slack = " + slack[i]);
            }
         }
 
         cplex.exportModel("mipex1.lp");
         cplex.end();
      }
      catch (IloException e) {
         System.err.println("Concert exception caught '" + e + "' caught");
      }
   }


   static void populateByRow (IloMPModeler  model,
                              IloNumVar[][] var,
                              IloRange[][]  rng) throws IloException {
      //定义变量及其范围
      double[]        xlb = {0.0, 0.0, 0.0, 2.0};  //变量的下界
      double[]        xub = {40.0, Double.MAX_VALUE, Double.MAX_VALUE, 3.0};  //变量的上界
      IloNumVarType[] xt  = {IloNumVarType.Float, IloNumVarType.Float,
                             IloNumVarType.Float, IloNumVarType.Int};
      IloNumVar[]     x  = model.numVarArray(4, xlb, xub, xt);
      var[0] = x;

      // Objective Function:  maximize x0 + 2*x1 + 3*x2 + x3 
      double[] objvals = {1.0, 2.0, 3.0, 1.0};
      model.addMaximize(model.scalProd(x, objvals));

      // 约束
      rng[0] = new IloRange[3];
      // - x0 + x1 + x2 + 10*x3 <= 20
      rng[0][0] = model.addLe(model.sum(model.prod(-1.0, x[0]),
                                        model.prod( 1.0, x[1]),
                                        model.prod( 1.0, x[2]),
                                        model.prod(10.0, x[3])), 20.0);
      // x0 - 3*x1 + x2 <= 30
      rng[0][1] = model.addLe(model.sum(model.prod( 1.0, x[0]),
                                        model.prod(-3.0, x[1]),
                                        model.prod( 1.0, x[2])), 30.0);
      // x1 - 3.5*x3 = 0 
      rng[0][2] = model.addEq(model.sum(model.prod( 1.0, x[1]),
                                        model.prod(-3.5, x[3])), 0.0);
   }
}
