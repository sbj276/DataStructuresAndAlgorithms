/*Threading*/
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
class SenderReceiverProblemThread{
	public static void main(String[] args) {
		Data data = new Data();
		Thread sender = new Thread(new Sender(data));		
		Thread receiver = new Thread(new Receiver(data));		
		sender.start();
		receiver.start();
	}
}

class Receiver implements Runnable{
	private Data data;
	public Receiver(Data data){
		this.data = data;
	}
	public void run(){
		for(String recM=data.receive();
			!"End".equals(recM);
			recM=data.receive()){
			System.out.println("Recived Message\t"+recM);
		// try {
  //               Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
  //           } catch (InterruptedException e)  {
  //               Thread.currentThread().interrupt();              
  //           }
		}
	}
}

class Sender implements Runnable{
	private Data data;
	public Sender(Data data){
		this.data = data;
	}
	public void run(){
		String[] packets={"Sachin","manisha","Anita","Badrinarayan","Payal","End"};
		for(String ele:packets){
			System.out.println("Sending..."+ele);
			data.send(ele);
			// try {
   //              Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
   //          } catch (InterruptedException e)  {
   //              Thread.currentThread().interrupt();              
   //          }
		}
	}
}

class Data{
	public String packate="";
	public boolean transfer = true; //true then send , if not true then receive

	public synchronized void send(String packate){
		while(!transfer){
			try { 
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();               
            }
		}

		transfer = false;
		this.packate = packate;
		notifyAll();
	}

	public synchronized String receive(){
		while(transfer){
		try { 
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();               
            }
		}

		transfer = true;
		notifyAll();
		return packate;
	}

}