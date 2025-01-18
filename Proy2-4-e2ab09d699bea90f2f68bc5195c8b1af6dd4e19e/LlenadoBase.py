#Grupo 4 Proyecto 2
#Programa Prototipo 
from neo4j import GraphDatabase
import logging
import csv
from neo4j.exceptions import ServiceUnavailable

def print_menu():
    print("1. Llenar la base de datos.")
    print("2. Eliminar todos los datos de la base de datos.")
    print("3. Salir.")

uri = "neo4j+s://3dc19c10.databases.neo4j.io"
username = "neo4j"
password = "9pNRzIjR3jc-POYdrDyYXKHxQ-xmhx6FNUXxvOUFA9c"
driver = GraphDatabase.driver(uri, auth=(username, password))

def llenarNeo(session):
    # Variables a utilizar para el llenado de datos
    var = 0
    artistas = []
    Generos = ["Rock","Pop","Latino"]
    for genero in Generos:
        var+=1
        s =""
        s = str(var)
        session.run("CREATE (c"+s+":GENER{name:'"+genero+"'}) ")

    # Abrir el archivo CSV en modo lectura
    with open('Canciones.csv', newline='') as csvfile:
        #Diccionario de Artistas
        reader = csv.reader(csvfile, delimiter='|')
        # Iterar sobre cada fila del archivo
        for row in reader:
            # Aqui vamos a relacionarlo con su genero
            var+=1
            #Revisamos antes que no se crearan artistas iguales
            if row[1] not in artistas:
                artistas.append(row[1])
            #creamos el nodo
            session.run("CREATE (s:SONG{name:'%s', artist:'%s', gener:'%s', duration:'%s',link:'%s'})" % (row[0],row[1],row[2],row[3],row[4]))
            #buscamos su relacion y la agregamos
            if "/" in row[2]:
                gen = row[2].split("/")
                for gn in gen:
                    qr ="MATCH (f:SONG{name:'%s'})  MATCH (l:GENER{name:'%s'}) CREATE (f)-[:GENERO]->(l)" % (row[0],gn)    
                    session.run(qr)
            else:
                new ="MATCH (f:SONG{name:'%s'})  MATCH (l:GENER{name:'%s'}) CREATE (f)-[:GENERO]->(l)" % (row[0],row[2])
                session.run(new)
    #Los vamos a relacionar con su genero
    for art in artistas:
        query = "CREATE (a:ARTIST{name:'%s'}) WITH a  MATCH (f:SONG{artist:'%s'}) CREATE (a)-[:TIENE]->(f)" % (art,art)
        session.run(query)

def borrarNeo(session):
    session.run("MATCH (n) DETACH DELETE n")

# abrir bd
with driver.session() as session:
#opciones para llenar bd y vaciarla
    while True:
        print_menu()
        choice = input("Elige una opción: ")
        if choice == '1':
            llenarNeo(session)
            print("Se ha llenado la base de datos de NEO4J con tus datos")
            print()
        elif choice == '2':
            borrarNeo(session)
            print("Se han eliminado tus datos de NEO4J")
            print()
        elif choice == '3':
            print("SALISTE")
            break
        else:
            print("Opción inválida. Inténtalo de nuevo.")

driver.close()