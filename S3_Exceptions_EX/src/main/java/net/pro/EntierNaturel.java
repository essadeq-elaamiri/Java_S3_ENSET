package net.pro;

/**
 * permettant de gérer des entiers naturels (positifs ou nuls)
 */
public class EntierNaturel {

    private final String EXCEPTION_MESSAGE = "La valeur entrée est négative !";

    private int val;
    public EntierNaturel(int val) throws NombreNegatifException{
        if (val<0) throw new NombreNegatifException(EXCEPTION_MESSAGE, val);
        else this.val = val;
    }

    public int getVal(){
        return this.val;
    }

    public void setVal(int val) throws NombreNegatifException {
        if (val<0) throw new NombreNegatifException(EXCEPTION_MESSAGE, val);
        else this.val = val;
    }
    public void decrementer() throws NombreNegatifException {
        if(this.val-1<0) throw new NombreNegatifException("Une valeur négative !", val);
        else this.val --;
		//this.setVal(val-1);
    }
}
