/*
5. 
a) Mostrar los nombres del artistas por orden de popularidad de menor a mayor.
b) Mostrar el nombre del album de las canciones que terminen con 'y'.
c) Obtener el nombre del album, cancion y artista con la popularidad por encima del promedio. */

-- a

select artists.name as Artist , max(plays) as Reproducciones
from artists
inner join songs on artists.id=songs.artist
group by artists.name
order by max(plays) asc;

-- b

select songs.title as Song, albums.title as Album
from songs
inner join albums on songs.album = albums.id
where songs.title like '%y';

-- c
select artists.name as Artist , max(plays) as Reproducciones
from artists,songs,albums
inner join songs on artists.id=songs.artist

where plays > 11.2
group by artists.name
order by max(plays) asc;

