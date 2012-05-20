CheapTrip
=========

Pareamtery uruchomieniowe

```
-gui -agents MainAgent:cheaptrip.agents.MainAgent
```

Co jest do zrobienia 
* Glowny agent otrzymuje wytyczne skad - dokad  i pobiera pelna trase od osobnego agenta 
* Glowny agent filturje trase [OK]
* Glowny agent wysyla przefiltorwana trase do agentow obliczajacych trase
* Agenci obliczajacy trase komunikują sie z agentami transportowymi 
  * Samoloty 
  * Busy
  * Pociagi
  * Baza/y wiedzy dla poszcegolnych agentow o trasach
* Agenci obliczajacy trase zwracaja gotowa trase do glownego agenta
* GUI