package com.example.rickandmortyapp.database

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.rickandmortyapp.model.charactersmodel.Character


@Database(
    entities = [Result::class],
    version = 1
)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun getCharactersDAO(): CharactersDAO
}

@Dao
interface CharactersDAO {

    @Insert(onConflict = REPLACE)
    fun insertCharacters(newCharacter: List<Character>)

    @Query(value = "SELECT * FROM character")
    suspend fun getAllCharacters(): List<Character>

    @Delete
    suspend fun deleteAllCharacters()

}
