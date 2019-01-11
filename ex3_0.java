    import java.io.*;
     
    class ex3_0 {
        static final int stackSize = 30;
        int sp = 0;
        int[] stack = new int[stackSize];
        
        public void main() {
            boolean endFlag = false;
            String buf;
            int cmd = 0,op = 0;
            while( endFlag == false ) {
                try{
                    BufferedReader br
                        = new BufferedReader(new InputStreamReader(System.in));
                    System.err.print("cmd:");
                    buf = br.readLine();
                    if( buf.equals("pop") ) {
                        cmd = 1;
                    } else if( buf.equals("push") ) {
                        cmd = 2;
                        System.err.print("op:");
                        buf = br.readLine();
                        op = Integer.parseInt(buf);
                    } else if( buf.equals("end") ) {
                        cmd = -1;
                        endFlag = true;
                        continue;
                    }
                    System.err.println("cmd = " + cmd + " op = " + op);
                } catch( Exception e) {
                    System.err.println(e);
                    continue;
                }
                switch( cmd ) {
                case 1:
                    op = pop();
                    System.out.println("POP " + op);
                    break;
                case 2:
                    push(op);
                    System.out.println("PUSH " + op);
                    break;
                }
            }
        }
        public int pop() {
            int r;
            sp--;
            r = stack[sp];
            return r;
        }
        public void push(int op) {
            stack[sp] = op;
            sp++;
            return;
        }
        
        public static void main(String args[]) {
            ex3_0 mainObj = new ex3_0();
            mainObj.main();
        }
    }
