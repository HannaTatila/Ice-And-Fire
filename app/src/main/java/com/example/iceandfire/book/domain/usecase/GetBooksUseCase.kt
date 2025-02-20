package com.example.iceandfire.book.domain.usecase

import com.example.iceandfire.book.domain.model.Book
import com.example.iceandfire.book.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow

class GetBooksUseCase(private val bookRepository: BookRepository) {

    operator fun invoke(): Flow<List<Book>> {
        return bookRepository.getBooks()
    }
}