#Grupo 4 Proyecto 2
#Programa Prototipo 
import time
import tkinter as tk
from tkinter import messagebox
from neo4j import GraphDatabase
import logging
from neo4j.exceptions import ServiceUnavailable
from query import *
from Mymusica import *
from Recomendacion import *

#mis datos
mi_coleccion = MiColeccion()
songs = []
generos = ["Rock","Pop","Latino"]
driver = None

def iniciar_sesion():
    uri = "neo4j+s://3dc19c10.databases.neo4j.io" # URI de la base de datos
    user = "neo4j" # Nombre de usuario
    password = "9pNRzIjR3jc-POYdrDyYXKHxQ-xmhx6FNUXxvOUFA9c" # Contraseña
    driver = GraphDatabase.driver(uri, auth=(user, password)) # Conexión al driver
    return driver

# Función para cerrar sesión en Neo4j
def cerrar_sesion(driver):
    driver.close()

# Función para hacer una consulta
def hacer_consulta(driver, consulta):
    with driver.session() as session:
        result = session.run(consulta)
        nombres = [record["nombre"] for record in result]
        result.consume()
    return nombres

def hacer_consultaCancion(driver, consulta):
    with driver.session() as session:
        result = session.run(consulta)
        print("|||||||||||||||||||||||||||||||||||||||")
        for record in result:
            nombre = record["nombre"]
            artista = record["artista"]
            genero = record["genero"]
            duracion = record["duracion"]
            video = record["video"]
            # Imprimir los valores
            generar_visualizacion_cancion(nombre, artista, duracion,genero)
            print("Video: ", video)
            print()



def mostrar_menu():
    print("______  ___             _____      ____  __                                  ")
    print("___   |/  /___  ___________(_)_______  |/ /__________________________________")
    print("__  /|_/ /_  / / /_  ___/_  /_  ___/_    /___  __ \_  ___/  _ \_  ___/_  ___/")
    print("_  /  / / / /_/ /_(__  )_  / / /__ _    | __  /_/ /  /   /  __/(__  )_(__  ) ")
    print("/_/  /_/  \__,_/ /____/ /_/  \___/ /_/|_| _  .___//_/    \___//____/ /____/  ")
    print("                                          /_/                                ")
    print("")
    print("1. Elige un género")
    print("")
    print("")
    print("2. Buscar canción deseada")
    print("")
    print("")
    print("3. Ver recomemndaciones")
    print("")
    print("")
    print("4. Salir del programa")
    print("")
    print("")

def procesar_opcion(opcion):
    driver = iniciar_sesion()
    if opcion == "1":
        print("Has seleccionado la opción 1.")
        animacion()
        start_opcion1()
    elif opcion == "2":
        print("Has seleccionado la opción 2.")
        animacion()
        start_opcion2()
    elif opcion == "3":
        print("Has seleccionado la opción 3.")
        animacion()
        start_opcion3()
    elif opcion == "4":
        print("Saliendo...")
        animacion()
        driver = iniciar_sesion()
        1
        return False
    else:
        print("Opción inválida. Por favor, selecciona una opción válida.")

    return True

def animacion():
    while True:
        for i in range(5):
            print("█████" * i + " " + "████" * (4 - i), end="\r")
            time.sleep(1.0)
        return False

def opcion1():
    print("Bienvenido", 
        "\n=======================================================\n"
        + "Bienvenido.... Procesando.....\n"
        + "Ha decidido elegir un genero musical\n"
        + "Entrando a archivos principales y sistema.... espere"
        +"\n======================================================\n"
        )
    options = ["Pop", "Rock", "Latino","regresar al menu principal"]
    for i in range(len(options)):
        print(f"{i+1}. {options[i]}")
    return len(options)



def start_opcion1():
    selection = 0
    options = 1
    while selection != options:
        options = opcion1()
        selection = int(input("Selecciona una opción: "))
        if selection !=4:
            mi_coleccion.add_genero(generos[selection-1]) #agregamos el genero que seleciono
            driver = iniciar_sesion() #iniciamos sesion en neo4j
            songs = hacer_consulta(driver,searchbygenero(generos[selection-1]))
            if selection == 1:
                # Ejecuta la consulta 
                print("\n CANCIONES DEL GENERO POP")
                pass
            if selection == 2:
                print("\n CANCIONES DEL GENERO ROCK")
                pass
            if selection == 3:
                print("\n CANCIONES DEL GENERO LATINO")
                pass
            for i,s in enumerate(songs):
                print(i,s)
            ingreso =int(input("Ingrese el numero de la cancion: "))
            guardarrecomendacion(mi_coleccion,driver,ingreso,songs)
            cancionconsulta = givememysong(songs[ingreso])
            hacer_consultaCancion(driver,cancionconsulta)
            cerrar_sesion(driver) # SIEMPRE SE DEBE DE CERRAR SESION 0_0
        else:
            # Juego terminado
            pass
        


def opcion2():
    print("Bienvenido", 
        "\n=======================================================\n"
        + "Bienvenido.... Procesando.....\n"
        + "A decidido elegir una cancion en especifico\n"
        + "Entrando a archivos principales y sistema.... espere"
        +"\n======================================================\n"
        )
    options = ["Buscar cancion deseada","regresar al menu principal"]
    for i in range(len(options)):
        print(f"{i+1}. {options[i]}")
    return len(options)



def start_opcion2():
    selection = 0
    options = 1
    options = opcion2()
    while selection != options:
        options = opcion2()
        selection = int(input("Selecciona una opción: "))
        if selection == 1:
            ingreso =input("Ingrese el nombre de la cancion: ")
            driver = iniciar_sesion() #iniciamos sesion en neo4j
            guardarcancion(mi_coleccion,driver,ingreso)
            cancionconsulta = givememysong(ingreso)
            hacer_consultaCancion(driver,cancionconsulta)
            cerrar_sesion(driver) # SIEMPRE SE DEBE DE CERRAR SESION 0_0
            pass
        else:
            # Juego terminado
            pass


def opcion3():
    print("Bienvenido", 
        "\n=======================================================\n"
        + "Bienvenido.... Procesando.....\n"
        + "Ha decidido ver recomendacion musicales en base a sus generos favoritos\n"
        + "Entrando a archivos principales y sistema.... espere"
        +"\n======================================================\n"
        )
    options = ["Ver recomendaciones","regresar al menu principal"]
    for i in range(len(options)):
        print(f"{i+1}. {options[i]}")
    return len(options)



def start_opcion3():
    selection = 0
    options = 1
    while selection != options:
        options = opcion3()
        selection = int(input("Selecciona una opción: "))
        if selection == 1:
            driver = iniciar_sesion() #iniciamos sesion en neo4j
            art = mi_coleccion.get_artists()
            genr = mi_coleccion.get_generos()
            s = mi_coleccion.get_actualsong()
            

            if(len(art) == 0): #si no tiene agregado ningun artista o genero le mostraremos por defecto canciones
                songs = hacer_consulta(driver,randomsongs()) #obtenemos canciones random
                pass
            #aqui esta la recomendacion
            else:

                songs= hacer_consulta(driver,recomendationbyartist(art,s)) #recomendamos por artista
                songs = list(set(songs))
                tamaño = len(genr)
                for numero in range(0, tamaño):
                    l = str(genr[numero][0])    
                    songs += hacer_consulta(driver,searchbygenero(l)) #recomendamos por genero
                    songs = list(set(songs)) #qiutamos duplicados
                songs += hacer_consulta(driver,randomsongs()) #recomendamos otras que nada que ver
                #quitamos la cancion actual de songs
                if(songs.__contains__(mi_coleccion.get_actualsong)):
                    songs.remove(mi_coleccion.get_actualsong)
                    pass
                pass
            #imprimimos las canciones
            for i,s in enumerate(songs):
                print(i,s)
            
            ingreso =int(input("Ingrese el numero de la cancion: "))
            guardarcancion(mi_coleccion,driver,songs[ingreso])
            cancionconsulta = givememysong(songs[ingreso])
            hacer_consultaCancion(driver,cancionconsulta)
            
            #agregamos el genero de la cancion
            
            cerrar_sesion(driver) # SIEMPRE SE DEBE DE CERRAR SESION 0_0
            
            pass
        else:
            # Juego terminado
            pass
def generar_visualizacion_cancion(nombre_cancion, autor, time,genero):
    print("╔════════════════╗")
    print("┃ ▁▂▃▅▆▇ 100% |")
    print("╚════════════════╝")
    print(f"CANCION: {nombre_cancion} ♫")
    print(f"GENERO: {genero} ♫")
    print(f"CREADOR: {autor}™®")
    print(f"0:00 ━❍──────── {time}")
    print("↻     ⊲  Ⅱ  ⊳     ↺")

def main():
    continuar = True
    while continuar:
        mostrar_menu()
        driver = iniciar_sesion() #iniciamos sesion en neo4j
        opcion = input("Selecciona una opción: ")
        continuar = procesar_opcion(opcion)

if __name__ == "__main__":
    main()
