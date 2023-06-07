Si deve realizzare un applicativo per la gestione delle prenotazioni delle postazioni aziendali.

Ogni postazione é identificata da un codice univoco, una descrizione, un tipo [PRIVATO, OPENSPACE, SALA
RIUNIONI], un numero massimo di occupanti ed un edificio. 

L'edificio ha un nome, un indirizzo ed una cittå.

Una postazione puö essere prenotata da un utente, che é identificato da uno username, un nome completo ed
una email. 

La prenotazione vale per un solo giorno e pub essere effettuata solo se per quel giorno la postazione
risulta libera.

Un utente pub ricercare le postazioni indicando il tipo di postazione desiderato e la cittå di interesse.

Un utente puö avere piü prenotazioni in corso, ma non puö prenotare piü di una postazione per una particolare
data.

Realizzare una applicazione Spring Boot, denominata GestionePrenotazioni, ed implementare il modello dei dati
necessario a realizzare Ilapplicazione. Implementare la persistenza utilizzando Spring Data JPA, realizzando
database e repositories necessari, oltre al mapping delle entities persistenti.