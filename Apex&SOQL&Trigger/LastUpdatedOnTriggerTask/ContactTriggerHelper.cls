public class ContactTriggerHelper {
    public static boolean isRunning = true;
    public static void setLastUpdatedOn(Set<Id> updatedIds){
        try{
           isRunning=false;
	   //As Trigger.new and Trigger.old returns read only records we have to fetch records using Ids we got
           List<Contact> finalContacts = [SELECT Id,LastUpdatedOn__c FROM Contact WHERE Id IN:updatedIds]; 
           for(Contact currentContact:finalContacts){
            	//system.debug('Record '+currentContact);
            	currentContact.LastUpdatedOn__c=Date.today();
        	}
            update finalContacts;
            system.debug('FinalContacts:'+finalContacts);
        }
        catch(Exception e){
            system.debug('Error:'+ e);
        }
        
    }
}