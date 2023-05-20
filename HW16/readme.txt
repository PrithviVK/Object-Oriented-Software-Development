HW16

Meter Manager

The assignment focuses on incrementing an electric meter count when a method getMeterCount() is called. When called a hashmap of type
<String,Integer> is returned. The hashmap stores the meter and it's updated value i.e., incremented value. In this case multiple 
threads might increase the meter count and might lead to race condition due to the incorrect increment in meter count
In the revised code a lock has been implemented on incrementing the meter count and getting the count by each thread that would be 
get locked. In this way no race condition is encountered.



