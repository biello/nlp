# nlp
some nlp fragments




2. Split the Query into Entities and Tokens:
At first, you are required to split the query (Q) into all possible combinations of free keywords, i.e., tokens (K = {ki ) and entities (E = {ei ), where
entities correspond to a subset of entities found in DoE formed by individual and/or combination of tokens in Q. This process is explained below:
Step 1: We look for probable entities in the Q by considering individual and/or combination of query tokens formed by combining the tokens in
the increasing order of the query string. Amongst them, we only select the entities present in DoE.
Step 2: Based on the selected list of entities found in Step-I enumerate all possible subsets of entities.
Step 3: Filter subsets of entities found in Step-2 such that for each subset the token count does not exceed the corresponding token count in
Q. We treat the filtered subset as the final entities of the corresponding query split.
Step 4: For each filtered entity subset, the rest of the keywords in the query, i.e., (Q \ wordsInEntities(eD) are treated as the tokens of the
query split.
Formally, let query be a a string of tokens, e.g., Q = " A B C D E F G " and dictionary of entities be DoE = {A B, DF, GK} . The list of entities formed
by the tokens in the query and/or combinations of query tokens (contained in DoE) is [A B, DF] and upon enumerating the possible subsets of the entities,
we get following different possible splits of the query to the lists of the entities and the tokens:
Split-I
Split-2:
Split-3:
Split-4:
