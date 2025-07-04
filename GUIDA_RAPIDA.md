# Guida Rapida - Cosa Posso Fare

## 🚀 PROGETTI PRONTI ALL'USO (TESTATI)

### 1. Distributore Bevande 🥤
```bash
cd EsercitazioneDistributoreBevande
javac -d build -cp src src/distributore/*.java src/distributore/*/*.java
java -cp build distributore.TestDistributore
```
**Cosa impari**: Eccezioni, Collezioni, Polimorfismo

### 2. Stream API Agriturismi 🏡
```bash
cd JavaAvanzato/StreamAPI1
mvn compile exec:java -Dexec.mainClass="main.MainStream"
```
**Cosa impari**: Stream API, Lambda, Functional Programming

### 3. Gestione Ristorante 🍽️
```bash
cd EsercitazioneGestioneRistorante
javac -d build -cp src src/gestioneristorante/*.java
java -cp build gestioneristorante.TestRistorante
```
**Cosa impari**: Multithreading, Sincronizzazione

## 📚 CATEGORIE PROGETTI

| Categoria | Progetti | Livello |
|-----------|----------|---------|
| **OOP Base** | Aula, Distributore, Ristorante | 🟢 Facile |
| **Java Avanzato** | StreamAPI, Concurrency, DAO | 🟡 Medio |
| **GUI/JavaFX** | TutorialJavaFX, ChatFX | 🟡 Medio |
| **Database** | JDBC, DAO Pattern | 🔴 Difficile |
| **Networking** | Chat, Socket | 🔴 Difficile |

## ⚡ AVVIO RAPIDO

### Per Principianti:
1. Inizia con **EsercitazioneDistributoreBevande**
2. Prova **Esercitazione1** (Gestione Aula)
3. Esplora **TutorialJavaFX**

### Per Intermedi:
1. **JavaAvanzato/StreamAPI1** (Stream API)
2. **EsercitazioneGestioneRistorante** (Threading)
3. **JavaAvanzato/EsAgriturismo** (Design complesso)

### Per Avanzati:
1. **JavaAvanzato/ConcurrencyAPI** (Concorrenza)
2. **JavaAvanzato/INGV_FX_DAO** (Architecture patterns)
3. **JavaAvanzato/MyAnnotation** (Reflection)

## 🔧 COMANDI UTILI

### Build Maven:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="NomeClasse"
```

### Build Standard:
```bash
javac -d build -cp src src/**/*.java
java -cp build package.MainClass
```

### Fix Java Version (pom.xml):
```xml
<maven.compiler.source>17</maven.compiler.source>
<maven.compiler.target>17</maven.compiler.target>
```

## 🎯 COSA IMPARERAI

✅ **Fundamentali OOP**: Classi, Ereditarietà, Polimorfismo, Incapsulamento  
✅ **Design Patterns**: DAO, Observer, Strategy, MVC  
✅ **Java Avanzato**: Stream API, Lambda, Reflection, Annotazioni  
✅ **Concorrenza**: Thread, Sincronizzazione, AtomicInteger  
✅ **GUI**: JavaFX, Event Handling, FXML  
✅ **Database**: JDBC, Connection Pool, Transazioni  
✅ **Networking**: Socket, Client-Server, Chat  

---
💡 **Suggerimento**: Inizia sempre con i progetti testati, poi esplora quelli più complessi!