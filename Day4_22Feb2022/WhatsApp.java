interface Message{

   void setIsReceived(Boolean isReceived);
   void setIsSeen(Boolean isSeen); 
   String getType();
   Boolean getIsReceived();
   Boolean getIsSeen();

   Boolean showReadReceipt();
   Boolean showBlueTick();
   Boolean sendMessage(); 
   Boolean getMessage();   
}

class TextMessage implements Message{
    String type;
    Boolean isReceived;
    Boolean isSeen;
   
    TextMessage(){
        type = "Text";
        isReceived = false;
        isSeen = false;
    }

    public void setIsReceived(Boolean isReceived){
      this.isReceived = isReceived;
    }
    public void setIsSeen(Boolean isSeen){
        this.isSeen = isSeen;
    }
   public String getType(){return this.type;}
   public Boolean getIsReceived(){return this.isReceived;}
   public Boolean getIsSeen(){return this.isSeen;}
   public Boolean showReadReceipt(){return false;}
   public Boolean showBlueTick(){return false;}
   public Boolean sendMessage(){return false;} 
   public Boolean getMessage(){return false;} 
}

class AudioMessage implements Message{
    String type;
    Boolean isReceived;
    Boolean isSeen;
   
    AudioMessage(){
        type = "Audio";
        isReceived = false;
        isSeen = false;
    }

    public void setIsReceived(Boolean isReceived){
      this.isReceived = isReceived;
    }
    public void setIsSeen(Boolean isSeen){
        this.isSeen = isSeen;
    }
   public String getType(){return this.type;}
   public Boolean getIsReceived(){return this.isReceived;}
   public Boolean getIsSeen(){return this.isSeen;}
   public Boolean showReadReceipt(){return false;}
   public Boolean showBlueTick(){return false;}
   public Boolean sendMessage(){return false;} 
   public Boolean getMessage(){return false;} 
   void play(){
       System.out.println("Playing music....");
   }
}
public class WhatsApp {
    public static void main (String[] args){
        TextMessage txtmsg = new TextMessage();
        AudioMessage audiomsg = new AudioMessage();
        System.out.println(txtmsg.getType());
        System.out.println(txtmsg.getIsReceived());
        System.out.println(audiomsg.getType());
        System.out.println(audiomsg.getIsSeen());
        audiomsg.play();
        
    }
}
