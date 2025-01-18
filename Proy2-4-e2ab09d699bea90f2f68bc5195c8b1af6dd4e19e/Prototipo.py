#Grupo 4 Proyecto 2
#Programa Prototipo 
from neo4j import GraphDatabase
import logging
from neo4j.exceptions import ServiceUnavailable
from query import *
from Mymusica import *
generos = ["Rock","Pop","Latino"]
mi_coleccion = MiColeccion()

# Función para iniciar sesión en Neo4j
def iniciar_sesion():
    uri = "neo4j+s://3dc19c10.databases.neo4j.io" # URI de la base de datos
    user = "neo4j" # Nombre de usuario
    password = "9pNRzIjR3jc-POYdrDyYXKHxQ-xmhx6FNUXxvOUFA9c" # Contraseña
    driver = GraphDatabase.driver(uri, auth=(user, password)) # Conexión al driver
    return driver

# Función para cerrar sesión en Neo4j
def cerrar_sesion(driver):
    driver.close()

# Función para mostrar el menú
def mostrar_menu():
    print("=== MENÚ ===")
    print("1. Comenzar")
    print("2. Salir")

# Función para hacer una consulta
def hacer_consulta(driver, consulta):
    with driver.session() as session:
        result = session.run(consulta)
        nombres = [record["nombre"] for record in result]
        result.consume()
    return nombres


# Función principal
def main():
    opcion = 0
    driver = None
    while opcion != 2:
        mostrar_menu()
        opcion = int(input("Seleccione una opción: "))
        if opcion == 1:
            driver = iniciar_sesion()
            show = "Que genero de musica te gusta: \n"
            for ind,g in enumerate(generos):
                show += str(ind)+" "+g+" \n"
            genero = int(input(show))
            mi_coleccion.add_genero(generos[genero])
            #Buscamos las canciones
            
            songs = hacer_consulta(driver,searchbygenero(generos[genero]))# Ejecuta la consulta 
            
            #Aqui le imprimimos sus primeras canciones.
            print("\n Eliga una cancion de las recomendadas, si quiere salir presione 25: ")
            for i,s in enumerate(songs):
                print(i,s)
            option = 0
            while option != 25:
                option = int(input(": "))
                if option!= 25:
                    mi_coleccion.add_song(songs[option]) #agregamos mis canciones.
                    r = hacer_consulta(driver,serachartistbysong(songs[option]))
                    mi_coleccion.add_artist(r[0]) #obtuve el artista.
                    print("ESTA SONANDO: ")
                    
                #ahora vamos a recomendarte canciones de tu artista/mas del genero y relacionados.

                
                print("\n Otros que te podrian gustar: \n")
                #Aqui vamos a incluir 
                art = mi_coleccion.get_artists()
                genr = mi_coleccion.get_generos()
                s = songs[option] #cancion actual
                songs= hacer_consulta(driver,recomendationbyartist(art,s)) + hacer_consulta(driver,recomendationbyyougeners(genr,s))
                for i,s in enumerate(songs):
                    print(i,s)

            #ahora vamos a poner a que elija una opcion. 
            cerrar_sesion(driver)
        elif opcion == 2:
            if driver is not None:
                cerrar_sesion(driver)
            print("Saliendo del programa...")
        else:
            print("Opción no válida.")
            
if __name__ == '__main__':
    main()