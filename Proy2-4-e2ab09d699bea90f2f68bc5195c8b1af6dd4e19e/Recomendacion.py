#Grupo 4 Proyecto 2
#Programa Recomendación
import time
import tkinter as tk
from tkinter import messagebox
from neo4j import GraphDatabase
import logging
from neo4j.exceptions import ServiceUnavailable
from query import *
from Mymusica import *
from MusicExpress import *

def guardarrecomendacion(coleccion:MiColeccion,driver,opcion,songs=[]):
    coleccion.add_song(songs[opcion]) #agregamos mis canciones
    r = hacer_consulta(driver,serachartistbysong(songs[opcion]))    
    coleccion.add_artist(r[0]) #obtuve el artista.
    coleccion.addactualsong(songs[opcion]) #agregamos la cancion actual

def guardarcancion(coleccion:MiColeccion,driver,song):
    coleccion.add_song(song)
    coleccion.add_genero(hacer_consulta(driver,givemegener(song))) #guardar el genero
    r = hacer_consulta(driver,serachartistbysong(song))    
    coleccion.add_artist(r[0]) #obtuve el artista. 
    coleccion.addactualsong(song) #agregamos la cancion actual

