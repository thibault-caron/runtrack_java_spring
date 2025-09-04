# Answers to questions

## Job 01
** Qu'est-ce que JPA et comment facilite-t-il l'accès aux bases de données ?**

Spring Data JPA fournit une implémentation de la couche d'accès aux données pour une   
application Spring. C'est une brique très pratique car elle permet de ne pas réinventer  
la roue de l'accès aux données à chaque nouvelle application et donc de se concentrer sur  
la partie métier.

## Job 02
**Pourquoi les bases de données en mémoire, comme H2, sont-elles utiles pendant le développement ?**

Cela permet d'avoir d'émuler la phase de production de l'application sans avoir besoin de modifier la véritable base de données.

L'avoir en mémoire permet une plus grande rapidité d'exécution pour les tests

## Job 03
**Quelle est l'importance des annotations, telles que @Entity, dans le contexte de JPA ?**

Dans Spring Boot avec JPA (Java Persistence API), les annotations comme @Entity jouent un rôle essentiel car elles permettent de relier le monde objet (Java) au monde relationnel (base de données):

1. Marquer les classes comme persistantes
    
	@Entity indique à JPA/Hibernate qu’une classe Java représente une table en base de données. Sans cette annotation, la classe est ignorée par l’ORM (Object Relational Mapping).
	
2. Définir le mapping entre classes et tables
  
	@Table(name = "users") → précise le nom de la table si différent du nom de la classe. Les champs annotés (@Id, @Column, @GeneratedValue, etc.) décrivent comment les attributs sont stockés dans la base.
	
3. Décrire les relations entre entités

	@OneToMany, @ManyToOne, @ManyToMany → définissent les liens entre classes et comment ils se traduisent en clés étrangères.
	
4. Contrôler le cycle de vie des objets

	JPA sait créer, lire, mettre à jour et supprimer (CRUD) ces objets en base sans écrire manuellement du SQL, grâce à ces annotations.

@generatedvalue permet de générer la valeur de l'id, strategy c'est une des propriétés de l'annotation et GenerationType.IDENTITY permet de faire de l'auto increment, à la place de IDENTITY y'a d'autres valeur, comme AUTO et c'est la DB qui choisi comment gérer


## Job 04


## Job 05
