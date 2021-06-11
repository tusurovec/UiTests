package sharaev.slava.ra.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sharaev.slava.ra.espresso.R
import sharaev.slava.ra.domain.entity.Transaction

class TransactionViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(getView(parent)) {

    private companion object {

        fun getView(parent: ViewGroup): View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.transaction_item, parent, false)
    }

    fun bind(item: Transaction) {
        val amount = itemView.findViewById<TextView>(R.id.transaction_amount)
        val description = itemView.findViewById<TextView>(R.id.transaction_description)

        amount.text = itemView.context.getString(
            R.string.balance_item_amount,
            item.amount.toPlainString(),
            item.currency.value
        )
        description.text = item.description
    }
}