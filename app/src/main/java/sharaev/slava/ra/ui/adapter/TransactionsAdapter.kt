package sharaev.slava.ra.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sharaev.slava.ra.domain.entity.Transaction

class TransactionsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var transactions: List<Transaction> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        TransactionViewHolder(parent)

    override fun getItemCount(): Int =
        transactions.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TransactionViewHolder).bind(transactions[position])
    }
}