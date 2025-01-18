#Grupo 4 Proyecto 2
#Clase Mi Coleccion 

#aqui creamos una clase que tendra generos, artistas y canciones del usuario. 
class MiColeccion:
    def __init__(self,mygeneros=[], myartists=[], mysongs=[]):
        self.mygeneros = mygeneros
        self.myartists = myartists
        self.mysongs = mysongs
        self.actualsong = ""
    
    def add_genero(self, genero):
        self.mygeneros.append(genero)
    
    def add_artist(self, artist):
        self.myartists.append(artist)
    
    def add_song(self, song):
        self.mysongs.append(song)

    def addactualsong(self,song):
        self.actualsong = song
    
    def get_generos(self):
        return self.mygeneros
    
    def get_artists(self):
        return self.myartists
    
    def get_songs(self):
        return self.mysongs
    
    def get_actualsong(self):
        return self.actualsong