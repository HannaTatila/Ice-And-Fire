package com.example.iceandfire.book.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iceandfire.book.domain.model.Book
import com.example.iceandfire.databinding.BookItemBinding

class BookListAdapter(
    private val bookList: List<Book>,
    private val onBookItemClickListener: (String) -> Unit
) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BookItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = bookList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bookList[position])
    }

    inner class ViewHolder(private val bookBinding: BookItemBinding) :
        RecyclerView.ViewHolder(bookBinding.root) {
        fun bind(book: Book) {
            bookBinding.textTitleBook.text = book.name
            bookBinding.root.setOnClickListener {
                onBookItemClickListener.invoke(book.url)
            }
        }

    }
}