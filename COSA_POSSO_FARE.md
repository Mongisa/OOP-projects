# Cosa Posso Fare - OOP Projects Repository

## Panoramica Generale
Questo repository contiene una collezione completa di progetti Object-Oriented Programming (OOP) in Java, che coprono diversi argomenti e livelli di difficoltà. È ideale per studenti che vogliono apprendere e praticare i concetti di programmazione orientata agli oggetti.

## Categorie di Progetti Disponibili

### 🎯 **Progetti Base OOP**

#### 1. Gestione Aula (Esercitazione1)
- **Cosa fa**: Simula la gestione di un'aula universitaria con entrata/uscita studenti
- **Concetti OOP**: Classi, incapsulamento, array, Stack
- **Funzionalità**:
  - Gestione posti disponibili/occupati
  - Stack LIFO per l'uscita degli studenti
  - Controllo capacità massima aula

#### 2. Distributore di Bevande (EsercitazioneDistributoreBevande)
- **Cosa fa**: Simula un distributore automatico di bevande con tessere
- **Concetti OOP**: Ereditarietà, polimorfismo, eccezioni personalizzate, collezioni
- **Funzionalità**:
  - ✅ **TESTATO**: Registrazione tessere e bevande
  - ✅ **TESTATO**: Sistema di crediti e acquisti
  - ✅ **TESTATO**: Gestione eccezioni (tessera non valida, bevanda esaurita, credito insufficiente)
  - ✅ **TESTATO**: Diversi tipi di bevande (Coca-Cola, Estathe, Sorgesana)

#### 3. Gestione Ristorante (EsercitazioneGestioneRistorante)
- **Cosa fa**: Sistema di gestione ristorante con thread per camerieri e cuoco
- **Concetti OOP**: Multithreading, sincronizzazione, I/O, backup automatico
- **Funzionalità**:
  - Sistema multi-thread con camerieri e cuoco
  - Gestione comande sincronizzate
  - Backup automatico dei dati

### 🚀 **Progetti Java Avanzato**

#### 4. Stream API con Agriturismi (JavaAvanzato/StreamAPI1)
- **Cosa fa**: Gestione e analisi dati di agriturismi usando Stream API
- **Concetti OOP**: Stream API, lambda expressions, functional programming
- **Funzionalità**:
  - ✅ **TESTATO**: Caricamento dati da CSV
  - ✅ **TESTATO**: Filtraggio e mappatura con Stream API
  - ✅ **TESTATO**: Operazioni funzionali su collezioni di agriturismi

#### 5. Concurrency API (JavaAvanzato/ConcurrencyAPI)
- **Cosa fa**: Simulazione di serbatoi che scaricano liquidi con sincronizzazione
- **Concetti OOP**: Concorrenza avanzata, AtomicInteger, sincronizzazione thread
- **Funzionalità**:
  - 5 serbatoi che si riempiono e scaricano
  - Sincronizzazione per condotto condiviso
  - Thread daemon e gestione concorrenza

#### 6. Gestione Agriturismi (JavaAvanzato/EsAgriturismo)
- **Cosa fa**: Sistema completo di gestione agriturismi
- **Concetti OOP**: Design patterns, gestione dati complessi
- **Funzionalità**:
  - Gestione posti letto, camping, parcheggi
  - Calcoli automatici capacità
  - Sistema di informazioni dettagliate

### 🖥️ **Progetti GUI e Interfacce**

#### 7. Tutorial JavaFX (TutorialJavaFX)
- **Cosa fa**: Esempi e tutorial per interfacce grafiche JavaFX
- **Concetti OOP**: Event handling, binding, FXML, scene graphs
- **Funzionalità**:
  - Esempi di controlli GUI
  - Gestione eventi
  - Layout e styling

#### 8. GUI Conferma Input (InputConfirmGUI)
- **Cosa fa**: Interfacce per conferma e validazione input utente
- **Concetti OOP**: Pattern MVC, validazione dati
- **Funzionalità**:
  - Dialoghi di conferma
  - Validazione input
  - Feedback utente

### 🗄️ **Progetti Database e Persistenza**

#### 9. JDBC Test (JavaAvanzato/JDBC_Test)
- **Cosa fa**: Connessione e operazioni database con JDBC
- **Concetti OOP**: DAO pattern, connection pooling, transazioni
- **Funzionalità**:
  - Connessioni database
  - CRUD operations
  - Gestione transazioni

#### 10. DAO con JavaFX (JavaAvanzato/INGV_FX_DAO)
- **Cosa fa**: Interfaccia grafica con pattern DAO per dati INGV
- **Concetti OOP**: DAO pattern, architettura a layer, data binding
- **Funzionalità**:
  - Interfaccia dati geologici
  - Pattern architetturale avanzato
  - Separazione logica/presentazione

### 🌐 **Progetti Networking e Comunicazione**

#### 11. Networking (JavaAvanzato/Networking)
- **Cosa fa**: Esempi di programmazione di rete
- **Concetti OOP**: Socket programming, client-server, protocolli
- **Funzionalità**:
  - Socket TCP/UDP
  - Comunicazione client-server
  - Chat e messaging

#### 12. Chat JavaFX (JavaAvanzato/myChatFX)
- **Cosa fa**: Applicazione di chat con interfaccia grafica
- **Concetti OOP**: Real-time communication, observer pattern
- **Funzionalità**:
  - Chat in tempo reale
  - Interfaccia user-friendly
  - Gestione utenti multipli

### 📚 **Progetti Specializzati**

#### 13. Sistema Annotazioni (JavaAvanzato/MyAnnotation)
- **Cosa fa**: Creazione e utilizzo di annotazioni personalizzate
- **Concetti OOP**: Reflection, meta-programming, annotation processing
- **Funzionalità**:
  - Annotazioni custom
  - Reflection API
  - Validazione automatica

#### 14. Quiz Matematico (JavaAvanzato/MyMathQuiz)
- **Cosa fa**: Applicazione quiz interattivo
- **Concetti OOP**: State pattern, random generation, scoring
- **Funzionalità**:
  - Generazione domande casuali
  - Sistema di punteggio
  - Feedback immediato

## 🛠️ Come Utilizzare i Progetti

### Prerequisiti
- Java 17 o superiore
- Maven (per progetti con pom.xml)
- IDE Java (IntelliJ IDEA, Eclipse, NetBeans)

### Esecuzione Progetti Maven
```bash
cd JavaAvanzato/StreamAPI1
mvn compile exec:java -Dexec.mainClass="main.MainStream"
```

### Esecuzione Progetti Standard
```bash
cd EsercitazioneDistributoreBevande
javac -d build -cp src src/distributore/*.java src/distributore/*/*.java
java -cp build distributore.TestDistributore
```

## 📖 Concetti OOP Coperti

### Fundamentali
- ✅ Classi e Oggetti
- ✅ Incapsulamento
- ✅ Ereditarietà
- ✅ Polimorfismo
- ✅ Astrazione

### Avanzati
- ✅ Design Patterns (DAO, Observer, Strategy)
- ✅ Gestione Eccezioni Personalizzate
- ✅ Generics e Collezioni
- ✅ Stream API e Programmazione Funzionale
- ✅ Multithreading e Concorrenza
- ✅ Reflection e Annotazioni
- ✅ I/O e Serializzazione

### Architetturali
- ✅ Layered Architecture
- ✅ MVC Pattern
- ✅ Dependency Injection
- ✅ Event-Driven Programming

## 🎯 Percorsi di Apprendimento Suggeriti

### Principiante
1. Esercitazione1 (Gestione Aula)
2. EsercitazioneDistributoreBevande
3. TutorialJavaFX

### Intermedio
1. EsercitazioneGestioneRistorante
2. JavaAvanzato/StreamAPI1
3. JavaAvanzato/EsAgriturismo

### Avanzato
1. JavaAvanzato/ConcurrencyAPI
2. JavaAvanzato/INGV_FX_DAO
3. JavaAvanzato/MyAnnotation

## 🚀 Progetti Testati e Funzionanti

✅ **EsercitazioneDistributoreBevande**: Completamente testato, dimostra tutti i concetti OOP base
✅ **JavaAvanzato/StreamAPI1**: Testato, eccellente per Stream API
✅ **EsercitazioneGestioneRistorante**: Compilato, pronto per test con threading

## 🔧 Risoluzione Problemi Comuni

### Java Version Issues
Se trovate errori di versione Java, modificate il `pom.xml`:
```xml
<maven.compiler.source>17</maven.compiler.source>
<maven.compiler.target>17</maven.compiler.target>
```

### Classpath Issues
Per progetti non-Maven, assicuratevi di includere tutte le dipendenze:
```bash
javac -d build -cp src src/**/*.java
```

## 🎨 Personalizzazione e Estensioni

Ogni progetto può essere esteso con:
- Nuove funzionalità
- Interfacce grafiche migliorate
- Database persistence
- API REST
- Testing automatizzato
- Documentazione JavaDoc

---

**Repository perfetto per**: Studenti di informatica, sviluppatori Java principianti/intermedi, chiunque voglia approfondire OOP in Java con esempi pratici e funzionanti!