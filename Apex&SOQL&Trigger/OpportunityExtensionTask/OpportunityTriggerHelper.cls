public class OpportunityTriggerHelper {
    public static Integer getDuration(Date startDate,Date endDate){
        return startDate.monthsBetween(endDate);
    }
    
    public static List<OpportunityExtension__c> createSlots(Id oppId,String oppName, Date startDate,Date endDate,Decimal amount){
        List<OpportunityExtension__c> slots = new List<OpportunityExtension__c>();
        Decimal slotAmount;
        if(amount == null){slotAmount = 0;}
        else{slotAmount = amount / getDuration(startDate,endDate);}
        
        OpportunityExtension__c firstSlot = new OpportunityExtension__c();
        firstSlot.Opportunity__c = oppId;
        firstSlot.Name = oppName + ':Slot1';
        firstSlot.StartDate__c = startDate;
        firstSlot.CloseDate__c = startDate.addDays(Date.daysInMonth(startDate.year(), startDate.month()));
        firstSlot.Amount__c = slotAmount;
        slots.add(firstSlot);
        for(Integer run=1;run<getDuration(startDate,endDate);run++){
            OpportunityExtension__c slot = new OpportunityExtension__c();
            Date slotStartDate = startDate.addMonths(run);
            slot.Opportunity__c = oppId;
            slot.Name = oppName + ':Slot'+Integer.valueOf(run +1);
            slot.StartDate__c = slotStartDate.addDays(1);
            slot.CloseDate__c = slotStartDate.addDays(Date.daysInMonth(slotStartDate.year(), slotStartDate.month()));
            slot.Amount__c = slotAmount;
            slots.add(slot);
        }
        system.debug(slots);
        return slots;
              
   }
    
    public static void addSlotRecords(Map<Id,Opportunity> oldMap, Map<Id,Opportunity> newMap){
            List<OpportunityExtension__c> allSlots = new List<OpportunityExtension__c>();
            if(oldMap == null){
                for(Id recordId:newMap.keySet()){
                    Opportunity currentOpportunity = newMap.get(recordId);
                    if(currentOpportunity.StartDate__c!=null && currentOpportunity.CloseDate__c!=null){
                     	allSlots.addAll(createSlots(currentOpportunity.Id,currentOpportunity.Name,currentOpportunity.StartDate__c,currentOpportunity.CloseDate__c,currentOpportunity.Amount));
                    }
                }
            }
            else{
                for(Id recordId:newMap.keySet()){
                    Opportunity oldRecord = oldMap.get(recordId);
                    Opportunity newRecord = newMap.get(recordId);
                    Date oldStartDate = oldRecord.StartDate__c;
                    Date oldCloseDate = oldRecord.CloseDate__c;
                    Decimal oldAmount = oldRecord.Amount;
                    Date newStartDate = newRecord.StartDate__c;
                    Date newCloseDate = newRecord.CloseDate__c;
                    Decimal newAmount = newRecord.Amount;
                    
                    if(oldStartDate!=null && oldCloseDate!=null  && oldAmount!=null){
                    	if(oldStartDate.isSameDay(newStartDate) && newCloseDate!=null || oldCloseDate.isSameDay(newCloseDate) && newStartDate!=null ||newAmount!=null && oldAmount!=newAmount && newStartDate!=null && newCloseDate!=null ){
                        	String oppName = oldRecord.Name+':%';
                        	List<OpportunityExtension__c> oldSlots = [SELECT Id,Name FROM OpportunityExtension__c WHERE Name LIKE :oppName];
                        	delete oldSlots;
                        	Opportunity currentOpportunity = newRecord;
                       	allSlots.addAll(createSlots(currentOpportunity.Id,currentOpportunity.Name,currentOpportunity.StartDate__c,currentOpportunity.CloseDate__c,currentOpportunity.Amount));
                    	}
                    }
                    else if(newStartDate!=null && newCloseDate!=null){
                        Opportunity currentOpportunity = newRecord;
                        allSlots.addAll(createSlots(currentOpportunity.Id,currentOpportunity.Name,currentOpportunity.StartDate__c,currentOpportunity.CloseDate__c,currentOpportunity.Amount));
                    
                    }
                }
            }
            
            insert allSlots;
        
    }
}