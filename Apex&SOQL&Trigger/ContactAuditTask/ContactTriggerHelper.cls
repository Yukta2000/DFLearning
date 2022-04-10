public class ContactTriggerHelper {
    public static void createAuditRecords(Map<Id,Contact> oldMap,Map<Id,Contact> newMap){
        List<ContactAudit__c> contactAudits = new List<ContactAudit__c>();
        Schema.FieldSet fieldsToTrack = Schema.SObjectType.Contact.fieldSets.ContactAuditFieldSet;
        List<String> fieldNames =  new List<String>();
        for(Schema.FieldSetMember field:fieldsToTrack.getFields()){
            //system.debug(field.fieldpath);
            fieldNames.add(field.fieldpath);
        }
        
        for(Id recordId:newMap.keySet()){
            Map<String,Object> updatedFields = new Map<String,String>();
            if(oldMap!=null){
                for(String fieldName:fieldNames){
                   Object oldValue = oldMap.get(recordId)?.get(fieldName);
              //We check first oldvalue, if null than we give true and new value added,if not null compare old and new values and if not same then only add new value 
                   if(oldValue!=null?(!oldValue.equals(newMap.get(recordId).get(fieldName))):true){
                        updatedFields.put(fieldName,newMap.get(recordId).get(fieldName));
                   } 
                }
                
                ContactAudit__c currentAudit = new ContactAudit__c();
                currentAudit.Contact__c=recordId;
                currentAudit.ChangedFields__c = updatedFields.toString();
                currentAudit.ModifiedBy__c=UserInfo.getName();
                contactAudits.add(currentAudit);
                }
            }
            
        system.debug('ContactAudits'+contactAudits);
        insert contactAudits;
        
        
    }
}