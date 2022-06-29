package by.it.ragach.calc.entity;

import by.it.ragach.calc.exception.CalcException;
import by.it.ragach.calc.interfaces.Operation;

public abstract class Var implements Operation {



      @Override
      public Var add(Var other) throws CalcException {
         throw new CalcException("Incorrect operation %s + %s%n", this,other);

      }

      @Override
      public Var sub(Var other)throws CalcException {
          throw new CalcException("Incorrect operation %s - %s%n", this,other);

      }

      @Override
      public Var mul(Var other)throws CalcException {
         throw new CalcException("Incorrect operation %s * %s%n", this,other);

      }

      @Override
      public Var div(Var other) throws CalcException {
          throw new CalcException("Incorrect operation %s / %s%n", this,other);

      }
  }