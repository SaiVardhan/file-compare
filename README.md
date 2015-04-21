# filematcher
match two files containing names.

rules of reading name from file :-

1) if the name contain lot of string separated by space then first name will be first string and 
   last name will be last string from these space separated strings. the remaining middle string or strings
    will become middle name
    
rules of comparing two names:-

1) first name should match with first name
2) last name should match with last name ( last name should either present in both names or not present in any name).
3) middle name is ignored during comparision.
