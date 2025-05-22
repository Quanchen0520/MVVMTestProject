import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mvvm_testproject.R

class AllSingleWordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_single_word, container, false)
        val textView = view.findViewById<TextView>(R.id.textview)
        textView.text = arguments?.getString("title")
        return view
    }

    companion object {
        fun newInstance(title: String) = AllSingleWordFragment().apply {
            arguments = Bundle().apply {
                putString("title", title)
            }
        }
    }

}