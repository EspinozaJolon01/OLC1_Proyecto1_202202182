
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analisador;

import java_cup.runtime.Symbol;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\027\000\002\002\004\000\002\002\006\000\002\003" +
    "\003\000\002\003\002\000\002\004\003\000\002\004\004" +
    "\000\002\005\003\000\002\005\003\000\002\005\003\000" +
    "\002\006\013\000\002\011\003\000\002\011\003\000\002" +
    "\011\003\000\002\011\004\000\002\011\003\000\002\007" +
    "\015\000\002\014\003\000\002\014\005\000\002\015\004" +
    "\000\002\015\004\000\002\010\014\000\002\016\003\000" +
    "\002\016\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\071\000\004\004\004\001\002\000\010\005\ufffe\006" +
    "\016\007\014\001\002\000\004\002\006\001\002\000\004" +
    "\002\001\001\002\000\010\005\ufff9\006\ufff9\007\ufff9\001" +
    "\002\000\010\005\ufffd\006\016\007\014\001\002\000\004" +
    "\005\uffff\001\002\000\004\005\071\001\002\000\010\005" +
    "\ufffa\006\ufffa\007\ufffa\001\002\000\004\061\056\001\002" +
    "\000\010\005\ufffb\006\ufffb\007\ufffb\001\002\000\004\061" +
    "\017\001\002\000\006\013\021\014\020\001\002\000\004" +
    "\072\042\001\002\000\004\064\022\001\002\000\004\065" +
    "\023\001\002\000\004\072\024\001\002\000\004\073\025" +
    "\001\002\000\004\062\026\001\002\000\006\067\027\073" +
    "\030\001\002\000\006\073\036\074\034\001\002\000\004" +
    "\005\ufff1\001\002\000\004\005\032\001\002\000\004\063" +
    "\033\001\002\000\010\005\ufff2\006\ufff2\007\ufff2\001\002" +
    "\000\006\073\036\074\034\001\002\000\004\070\040\001" +
    "\002\000\006\073\036\074\034\001\002\000\004\070\uffef" +
    "\001\002\000\004\005\ufff0\001\002\000\004\070\uffee\001" +
    "\002\000\004\073\043\001\002\000\004\062\044\001\002" +
    "\000\010\071\052\073\051\074\046\001\002\000\004\005" +
    "\ufff6\001\002\000\004\005\ufff5\001\002\000\004\005\ufff7" +
    "\001\002\000\004\005\054\001\002\000\004\005\ufff3\001" +
    "\002\000\004\073\053\001\002\000\004\005\ufff4\001\002" +
    "\000\004\063\055\001\002\000\010\005\ufff8\006\ufff8\007" +
    "\ufff8\001\002\000\004\014\057\001\002\000\004\072\060" +
    "\001\002\000\004\071\061\001\002\000\004\073\062\001" +
    "\002\000\004\062\063\001\002\000\002\001\002\000\004" +
    "\005\uffeb\001\002\000\004\005\uffec\001\002\000\004\005" +
    "\067\001\002\000\004\063\070\001\002\000\010\005\uffed" +
    "\006\uffed\007\uffed\001\002\000\004\004\072\001\002\000" +
    "\004\002\000\001\002\000\004\005\ufffc\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\071\000\004\002\004\001\001\000\016\003\011\004" +
    "\010\005\007\006\014\007\012\010\006\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\014\004" +
    "\072\005\007\006\014\007\012\010\006\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\014\030\001\001\000\004\015\034\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\015\040\001\001\000\002\001\001\000\004\015" +
    "\036\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\010\011" +
    "\047\012\046\013\044\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\010" +
    "\016\065\017\064\020\063\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



     public void syntax_error(Symbol s){
        System.out.println("Error sintactico: "+s.value+" linea: "+s.left+" columna: "+s.right);
    }
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
        System.out.println("Error sintactico unrecovered: "+s.value+" linea: "+s.left+" columna: "+s.right);
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= Program CODIGO End Program 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // CODIGO ::= COMPILACION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("CODIGO",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // CODIGO ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("CODIGO",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // COMPILACION ::= SENTENCIA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMPILACION",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // COMPILACION ::= SENTENCIA COMPILACION 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("COMPILACION",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // SENTENCIA ::= TDOUBLE 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("SENTENCIA",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // SENTENCIA ::= TCHAR 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("SENTENCIA",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // SENTENCIA ::= TARRELGOS 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("SENTENCIA",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // TDOUBLE ::= Var Dos_puntos Tipo_double Doble_puntos Identificador Reserve OPERA End P_coma 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("TDOUBLE",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // OPERA ::= OARIT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("OPERA",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // OPERA ::= OESTAD 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("OPERA",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // OPERA ::= Numero 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("OPERA",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // OPERA ::= Arroba Identificador 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("OPERA",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // OPERA ::= Identificador 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("OPERA",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // TCHAR ::= Var Dos_puntos Tipo_char Parent_a Parent_c Doble_puntos Identificador Reserve CADENA End P_coma 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("TCHAR",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-10)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // CADENA ::= Identificador 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("CADENA",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // CADENA ::= C_dobles_a STRING C_dobles_c 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("CADENA",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // STRING ::= Identificador STRING 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("STRING",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // STRING ::= Numero STRING 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("STRING",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // TARRELGOS ::= Arr Dos_puntos Tipo_double Doble_puntos Arroba Identificador Reserve TIP_A End P_coma 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("TARRELGOS",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-9)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // TIP_A ::= ARR_NUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("TIP_A",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // TIP_A ::= ARR_CA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("TIP_A",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}