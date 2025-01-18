
#Grupo 4 Proyecto 2
#Consultas 

def searchbygenero(migenero):
    toresult = "MATCH (c:SONG {{gener:'{}'}}) RETURN c.name AS nombre ORDER BY rand() LIMIT 10".format(migenero)
    return toresult

def serachbyartist(artist):
    toresult = "MATCH(c:SONG {{artist:'{}'}}) RETURN c.name AS nombre ORDER BY rand() LIMIT 10".format(artist)
    return toresult

def serachartistbysong(song):
    toresult = "MATCH (a:ARTIST)-[:TIENE]->(c:SONG {{name:'{}'}}) RETURN a.name AS nombre".format(song)
    return toresult

def recomendationbyartist(artist,actualsong):
    #primero te buscaremos canciones de tu artista y luego del genero.
    toresult = "MATCH (a:ARTIST)-[:TIENE]->(c:SONG) WHERE a.name IN {} AND NOT c.name='{}' RETURN c.name AS nombre".format(artist,actualsong) #aqui jala de toda la coleccion
    return toresult

def recomendationbyyougeners(generos,actualsong): #aqui busca todas tus canciones por genero
    toresult = "MATCH (c:SONG)-[:GENERO]->(g:GENER) WHERE g.name IN {} AND NOT c.name='{}' RETURN c.name AS nombre ORDER BY rand() LIMIT 10".format(generos,actualsong) #aqui jala de toda la coleccion
    return toresult

def givememysong(song):
    toresult = "MATCH(c:SONG {{name:'{}'}}) RETURN c.name AS nombre,c.artist AS artista,c.gener AS genero,c.duration AS duracion,c.link AS video".format(song)
    return toresult

def givemegener(song):
    toresult = "MATCH(c:SONG{{name:'{}'}})-[:GENERO]->(g:GENER) RETURN g.name AS nombre".format(song)
    return toresult

def randomsongs():
    toresult = "MATCH(c:SONG) RETURN c.name AS nombre ORDER BY rand() LIMIT 10"
    return toresult

