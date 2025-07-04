#!/bin/bash

# Script per testare i progetti OOP
# Usage: ./test_projects.sh

echo "🚀 BENVENUTO NEI PROGETTI OOP!"
echo "================================"
echo ""
echo "Seleziona quale progetto vuoi testare:"
echo ""
echo "1. 🥤 Distributore Bevande (OOP Base + Eccezioni)"
echo "2. 🏡 Stream API Agriturismi (Java Avanzato)"
echo "3. ⚡ Concurrency API (Threading Avanzato)"
echo "4. 🍽️ Gestione Ristorante (Multi-threading)"
echo "5. 📚 Mostra tutti i progetti disponibili"
echo "6. ❌ Esci"
echo ""

read -p "Inserisci la tua scelta (1-6): " choice

case $choice in
    1)
        echo ""
        echo "🥤 AVVIO DISTRIBUTORE BEVANDE..."
        echo "================================"
        cd EsercitazioneDistributoreBevande
        echo "Compilazione in corso..."
        javac -d build -cp src src/distributore/*.java src/distributore/*/*.java 2>/dev/null
        if [ $? -eq 0 ]; then
            echo "✅ Compilazione riuscita!"
            echo "🚀 Avvio test..."
            echo ""
            java -cp build distributore.TestDistributore
        else
            echo "❌ Errore di compilazione"
        fi
        ;;
    2)
        echo ""
        echo "🏡 AVVIO STREAM API AGRITURISMI..."
        echo "================================="
        cd JavaAvanzato/StreamAPI1
        echo "Compilazione Maven in corso..."
        mvn -q compile
        if [ $? -eq 0 ]; then
            echo "✅ Compilazione riuscita!"
            echo "🚀 Avvio applicazione..."
            echo ""
            mvn -q exec:java -Dexec.mainClass="main.MainStream"
        else
            echo "❌ Errore di compilazione Maven"
        fi
        ;;
    3)
        echo ""
        echo "⚡ AVVIO CONCURRENCY API..."
        echo "=========================="
        cd JavaAvanzato/ConcurrencyAPI
        echo "Compilazione Maven in corso..."
        mvn -q compile
        if [ $? -eq 0 ]; then
            echo "✅ Compilazione riuscita!"
            echo "🚀 Avvio simulazione serbatoi (durata: 10 secondi)..."
            echo ""
            timeout 10s mvn -q exec:java -Dexec.mainClass="main.Main"
            echo ""
            echo "✅ Simulazione completata!"
        else
            echo "❌ Errore di compilazione Maven"
        fi
        ;;
    4)
        echo ""
        echo "🍽️ GESTIONE RISTORANTE..."
        echo "========================"
        cd EsercitazioneGestioneRistorante
        echo "Compilazione in corso..."
        javac -d build -cp src src/gestioneristorante/*.java 2>/dev/null
        if [ $? -eq 0 ]; then
            echo "✅ Compilazione riuscita!"
            echo "🚀 Avvio gestione ristorante..."
            echo "⚠️  NOTA: Questo programma richiede input interattivo"
            echo "   Premi Ctrl+C per uscire quando necessario"
            echo ""
            java -cp build gestioneristorante.TestRistorante
        else
            echo "❌ Errore di compilazione"
        fi
        ;;
    5)
        echo ""
        echo "📚 TUTTI I PROGETTI DISPONIBILI:"
        echo "================================"
        echo ""
        echo "🎯 PROGETTI BASE OOP:"
        echo "  • Esercitazione1 - Gestione Aula Universitaria"
        echo "  • EsercitazioneDistributoreBevande - Distributore Automatico"
        echo "  • EsercitazioneGestioneRistorante - Sistema Ristorante Multi-thread"
        echo ""
        echo "🚀 JAVA AVANZATO:"
        echo "  • JavaAvanzato/StreamAPI1 - Stream API e Functional Programming"
        echo "  • JavaAvanzato/ConcurrencyAPI - Threading e Sincronizzazione"
        echo "  • JavaAvanzato/EsAgriturismo - Gestione Agriturismi"
        echo "  • JavaAvanzato/INGV_FX_DAO - DAO Pattern con JavaFX"
        echo "  • JavaAvanzato/MyAnnotation - Annotazioni Personalizzate"
        echo "  • JavaAvanzato/MyMathQuiz - Quiz Matematico Interattivo"
        echo ""
        echo "🖥️ GUI E INTERFACCE:"
        echo "  • TutorialJavaFX - Tutorial JavaFX"
        echo "  • InputConfirmGUI - GUI per Input/Conferma"
        echo "  • JavaAvanzato/myChatFX - Chat con JavaFX"
        echo ""
        echo "🗄️ DATABASE E PERSISTENZA:"
        echo "  • JavaAvanzato/JDBC_Test - Connessioni Database"
        echo ""
        echo "🌐 NETWORKING:"
        echo "  • JavaAvanzato/Networking - Programmazione di Rete"
        echo ""
        echo "Per maggiori dettagli, consulta:"
        echo "  📖 COSA_POSSO_FARE.md - Documentazione completa"
        echo "  ⚡ GUIDA_RAPIDA.md - Guida rapida per iniziare"
        ;;
    6)
        echo ""
        echo "👋 Arrivederci! Buono studio con OOP!"
        exit 0
        ;;
    *)
        echo ""
        echo "❌ Scelta non valida. Riprova con un numero da 1 a 6."
        ;;
esac

echo ""
echo "🔄 Vuoi testare un altro progetto? Rilancia lo script!"
echo "📚 Per maggiori informazioni, leggi COSA_POSSO_FARE.md"