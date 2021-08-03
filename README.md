# jracetrack

##Introduzione
<b>Obiettivo: </b></br> Realizzare un progetto che simula il gioco Formula 1 carta e penna.
Per l’implementazione è stato usato il pattern di programmazione MVC. Per rendere più comprensibile il tutto e per rispettare questo pattern, è stata fatta una divisione di packages in: Model, Controller, e View.
All’interno del package Model ci sono dei sottopackages che servono per una migliore organizzazione del codice.
Per la creazione del progetto è stato usato il framework gradle. Il progetto è stato realizzato usando delle funzionalità messe a disposizione dalla versione 1.8 in poi della jdk; per questo motivo è stato deciso di sviluppare il progetto usando la versione 11 della jdk.
##Descrizione gioco
L’applicazione deve essere in grado di fornire un’implementazione per il gioco Formula 1 carta e penna. Si tratta di un gioco di carta e matita che si gioca su un foglio di carta quadrettata, sul quale viene disegnato un circuito automobilistico di fantasia, con una linea di partenza e una linea di arrivo (che possono anche coincidere se il circuito è circolare). Il gioco simula una gara tenendo conto dell'inerzia dei veicoli (per esempio, è necessario frenare quando si affronta una curva).
Altre informazioni più dettagliate sono al seguente <a href = https://it.wikipedia.org/wiki/Formula_1_(gioco)>link </a>. 
##Descrizione progetto
Il progetto si focalizza su quattro aspetti fondamentali:
<br>• Tracciato
<br>• Macchina
<br>• Giocatore
<br>• Gara
<br><br>
All’avvio un file di configurazione iniziale viene caricato e viene creata la gara. I file di configurazione caricati sono due: uno per il circuito e uno per i giocatori. Al giocatore viene poi creata una macchina con un colore generato in modo randomico.
##Descrizione delle responsabilità
###Model
<b>▪ Car (interfaccia): </b> le classi che implementano questa interfaccia hanno la responsabilità di gestire le informazioni e le operazioni legate ad una macchina del gioco.
<br><b>o DefaultCar (classe):</b> classe che implementa l’interfaccia Car. Questa classe definisce un’implementazione per una macchina. Una macchina è caratterizzata da un circuito, uno stato, un colore ed una lista che contiene tutte le locazioni della macchina. In questa implementazione è una LinkedList.
<br><b>▪ Player (interfaccia):</b> le classi che implementano questa interfaccia hanno la responsabilità di gestire tutte le informazioni e operazioni legate ad un giocatore.
<br><b>o DefaultBasePlayer (classe astratta):</b> questa classe implementa l’interfaccia Player e implementa le funzionalità comuni a tutti i player. Ad un giocatore viene assegnata una macchina.
<br><b>o PlayerBot (classe):</b> classe che estende la classe astratta DefaultBasePlayer. Ha la responsabilità di definire il tipo del giocatore (bot in questo caso) e il modo in cui muove la macchina. Essendo un bot, per questa implementazione il movimento viene fatto in modo randomico.
<br><b>o PlayerInteractive (classe):</b> classe che estende la classe astratta DefaultBasePlayer. Ha la responsabilità di definire il tipo del giocatore (interattivo in questo caso) e il modo in cui muove la macchina. Essendo un giocatore interattivo, per questa implementazione il prossimo punto in cui posizionare la macchina viene deciso dal giocatore stesso, inserendo uno dei prossimi punti disponibili.
<br><b>▪ Race (interfaccia):</b> le classi che implementano questa interfaccia hanno la responsabilità di gestire i giocatori e altri dati dell’applicazione.
<br><b>o DefaultRace (classe):</b> classe che implementa l’interfaccia Race e ha la responsabilità di gestire una lista di giocatori, in questo caso ArrayList, e di gestire lo stato della gara. Assegna ad un giocatore una macchina, crea il tracciato e setta il giocatore vincitore.
<br><b>▪ TypePlayer (enumerazione):</b> definisce i tipi dei giocatori.
<br><b>▪ DefaultStateCar (enumerazione):</b> definisce gli stati della macchina.
<br><b>▪ Track (interfaccia):</b> le classi che implementano questa interfaccia hanno la reponsabilità di gestire le informazioni legate al circuito e alle macchine nel circuito.
<br><b>o DefaultTrack (classe):</b> classe che implementa l’interfaccia Track. Il circuito in questa implementazione è rappresentato come un HashMap composto da macchina e locazione. Ha tre liste: una per gestire tutti i punti che formano una linea di partenza, una per gestire tutti i punti che formano una linea di arrivo e un’ultima per gestire tutti i punti che formano i bordi del circuito. Il circuito è caratterizzato da una larghezza, che, secondo le regole standard, deve avere un minimo di due quadretti. Si occupa di creare una macchina, alla quale, setta una locazione iniziale in uno dei punti che formano la linea di partenza, in modo randomico. La macchina verrà poi aggiunta all’hashmap, che verrà aggiornato ad ogni cambiamento di posizione della macchina.
####❖ Location
<b>▪ Location (interfaccia):</b> interfaccia parametrizzata con un tipo L. Si tratta di un’interfaccia funzionale che specifica un metodo per la creazione delle prossime locazioni della macchina. Le classi che implementeranno questa interfaccia hanno la responsabilità di rappresentare la locazione nel campo.
<br><b>o DefaultLocation (classe):</b> classe dichiarata final per evitare di creare sottoclassi. Ha la responsabilità di definire un tipo per la locazione.
<br><b>▪ FactoryLocation (interfaccia):</b> le classi che implementano questa interfaccia hanno la responsabilità di definire un modo per la creazione di un oggetto che rappresenti una Location.
<br><b>o MyFactoryLocation (classe):</b> classe che si occupa di definire un modo per la creazione di un oggetto DefaultLocation.
####❖ Reader
<b>▪ ObjectReader (interfaccia):</b> Interfaccia che permette di leggere da file un qualsiasi oggetto. Le classi che implementeranno questa interfaccia avranno la responsabilità di implementare una soluzione per la lettura di un oggetto da file e di specificare il tipo di file.
<br><b>▪ PlayerReaderTXT (classe):</b> Classe che specifica un Reader per la lettura di un file, che corrisponde ad una lista di giocatori che parteciperanno alla gara. Il formato del file deve essere ".txt" e deve essere scritto in questo modo:
<br>TIPOGIOCATORE;nomeGiocatore,
<br>TIPOGIOCATORE;nomeGiocatore,
<br>TIPOGIOCATORE;nomeGiocatore,
<br>Ogni stringa rappresenta un giocatore. La stringa ha un separatore di campi: ";" che la divide in due campi. Il primo campo indica il tipo del giocatore, mentre il secondo campo indica il nome del giocatore. È possibile inserire sia giocatori Bot che giocatori Interattivi, ma non entrambi nella stessa gara.
<br><b>▪ TrackReaderTXT (classe):</b> Classe che specifica un Reader per la lettura di un file, che corrisponde ad un tracciato. Il formato del file deve essere ".txt" e deve essere scritto in questo modo:
<br>(x,y),
<br>(x,y),
<br>(x,y),
<br>(x,y),
<br>(x,y)
<br>;
<br>(x,y),
<br>(x,y)
<br>;
<br>(x,y),
<br>(x,y)
<br>Le coordinate scritte fino al primo ";" specificano i punti che corrispondono ai muri del circuito. Dopo di che vengono specificate le coordinate che rappresentano i punti che formano una linea di partenza, e infine dopo l'ultimo ";" vengono specificate le coordinate che rappresentano i punti che formano la linea di arrivo.
###Controller
<b>▪ Controller (interfaccia):</b> Le classi che implementano questa interfaccia devono definire un controller per l’applicazione.
<br><b>o DefaultController (classe):</b> classe che implementa un controller di default per l’applicazione.
<br><b>▪ ControllerManager (interfaccia):</b> Le classi che implementato questa interfaccia hanno la responsabilità di creare un oggetto controller.
<br><b>o MyfactoryControllerManager (classe):</b> definisce un modo per la creazione di un oggetto DefaultController.
###View
<b>View (interfaccia):</b> interfaccia che rappresenta la vista per l’applicazione. Le classi che implementano questa interfaccia hanno la responsabilità di definire un tipo di vista.
<br><b>o ConsoleView (classe):</b> classe che ha la responsabilità di definire una vista a console.
##Conclusioni
Questo progetto è stato realizzato per l'esame di programmazione avanzata del corso di laurea in informatica all'università di Camerino.
Grazie al rispetto dei principi <b>SOLID</b>, è possibile fornire:
<br>-altre implementazioni per le componenti del progetto;
<br>-una nuova vista (ad esempio: grafica);
<br>-una diversa implementazione per il controller.