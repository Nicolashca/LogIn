package Pin;
import java.util.Arrays;

public  class Generator {
    public String generate(int n )
    {
        char[] pin = new char[n];
        char c; //='1';

        for( int i = 0; i<n; i++) {

            while( true ) {
                c = (char)getRandom('!', '~');
                        if (!isPrintable(c))
                            continue;


                        if( Arrays.binarySearch( pin, c ) >= 0 )
                            continue;
                        pin[i] = c;
                        break;
            }
        }

        return new String(pin);
    }



    private byte getRandom( char from, char to )
    {

        int random = (int) (Math.random()*( (int)to - (int)from )) +
                (int)from;


        return (byte)random;
    }



    private boolean isNumber( char v )
    {
        if( v >= '0' && v <= '9' )
            return true;
        return false;
    }

    private boolean isLetterSmall( char v )
    {
        if( v >= 'a' && v <= 'z' )
            return true;
        return false;
    }

    private boolean isLetterBig( char v )
    {
        if( v >= 'A' && v <= 'Z' )
            return true;
        return false;
    }

    private boolean isLetter( char v )
    {
        if( isLetterSmall(v) || isLetterBig(v) )
            return true;
        return false;
    }

    private boolean isSpecSymbol( char v )
    {
        if( (v >= '!' && v <= '/') ||
                (v >= ':' && v <= '@') ||
                (v >= '[' && v <= '`') ||
                (v >= '{' && v <= '~') )
            return true;
        return false;
    }

    private boolean isPrintable( char v )
    {
        if( isNumber(v) || isLetter(v) || isSpecSymbol(v) )
            return true;
        return false;
    }

    public void checker(String message,int n)  throws PinException
    {
        /* Checl pin length */
        if( message.length() != n )
        {
            throw new PinException( "PIN length is not " + n );
        }

        /* Check for  number */
        boolean haveNumber = false;
        for(int i=0;i<n;i++)
        {
            if( isNumber(message.toCharArray()[i]) )
            {
                haveNumber = true;
                break;
            }
        }
        if( !haveNumber )
        {
            throw new PinException( "PIN has no numbers" );
        }

        /* Check for small letter */
        boolean haveSL = false;
        for(int i=0;i<n;i++)
        {
            if( isLetterSmall(message.toCharArray()[i]) )
            {
                haveSL = true;
                break;
            }
        }

        if( !haveSL )
        {
            throw new PinException( "PIN has no small letters" );
        }

        /* Check for big letter */
        boolean haveBL = false;
        for(int i=0;i<n;i++)
        {
            if( isLetterBig(message.toCharArray()[i]) )
            {
                haveBL = true;
                break;
            }
        }

        if( !haveBL )
        {
            throw new PinException( "PIN has no big letters" );
        }

        /* Check for spec symbol */
        boolean haveSS = false;
        for(int i=0;i<n;i++)
        {
            if( isSpecSymbol(message.toCharArray()[i]) )
            {
                haveSS = true;
                break;
            }
        }

        if( !haveSS )
        {
            throw new PinException( "PIN has no spec symbol" );
        }
    }
}

