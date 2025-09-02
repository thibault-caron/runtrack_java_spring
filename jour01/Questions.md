# Answers to questions

## Job 01
**Q: Qu'est-ce que Spring Initializr et comment peut-il faciliter la création d'un nouveau projet Spring?**

Spring Initializr est un outil en ligne (utilisable via des IDE comme IntelliJ ou des suites de logiciel comme Spring Tools Suite) qui permet de générer rapidement la structure de base d'un nouveau projet Spring.
Cela permet d'éviter de configurer manuellement le projet (via pom.xml par exemple si on utilise Maven).

## Job 02
**Q: Pourquoi le fichier pom.xml est-il crucial dans un projet Maven ?**

Spring Initializr est un outil en ligne (utilisable via des IDE comme IntelliJ ou des suites de logiciel comme Spring Tools Suite) qui permet de générer rapidement la structure de base d'un nouveau projet Spring.

Cela permet d'éviter de configurer manuellement le projet (via pom.xml par exemple si on utilise Maven).

## Job 03
**Q: Qu'est-ce qu'un contrôleur dans le contexte de Spring MVC ?**

Le controller dans le contexte de Spring MVC se charge de la communication entre le modèle et la view.
Il fait le lien entre notre code et le framework qui va recevoir des requêtes HTTP et va pouvoir renvoyer une réponse comme une page HTML.

## Job 04
**Q: Comment Spring permet-il l'injection de propriétés depuis des fichiers de configuration?**

Les propriétés définies dans les fichiers de configurations (application.properties ou application.yml) peuvent être injectées dans des composants.

Spring va se charger d'aller récupérer les valeurs des propriétés se trouvant dans les fichiers de configuration. Cette fonctionnalité nous permet ensuite d'utiliser le décorateur @Value et d'injecter la valeur voulu dans la variable de notre choix.

## Job 05
**Q:  Pourquoi serait-il utile d'avoir différents profils dans une application Spring ?**

Il est très utile et important d'avoir des configurations différentes afin de mieux gérer les différents environnements. Le plus connu est l'environnement de développement qui ne demande pas du tout les même configurations que l'environnement de production. L'environnement de dev va plus se concentrer sur des configurations qui permet de tester rapidement et avoir les modifications du code sans avoir à relancer l'application par exemple alors que pour la production, l'important et d'avoir l'environnement le plus efficient pour l'utilisation.

## Job 06
**Q: En quoi la dépendance DevTools est-elle bénéfique pour le développement ?**
