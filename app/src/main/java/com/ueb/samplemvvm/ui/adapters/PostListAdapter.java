package com.ueb.samplemvvm.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ueb.samplemvvm.R;
import com.ueb.samplemvvm.databinding.ItemPostBinding;
import com.ueb.samplemvvm.model.Results;
import com.ueb.samplemvvm.ui.bookdetail.BookDetailFragment;
import com.ueb.samplemvvm.util.Router;
import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {

    private Router router;
    private static final String TAG = "PostListAdapter";
    private List<Results.Book> postList;

    public PostListAdapter() {

    }

    public PostListAdapter(List<Results.Book> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        router = new Router((AppCompatActivity) parent.getContext());
        ItemPostBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_post, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemPostBinding binding;

        public ViewHolder(ItemPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Results.Book book) {
            binding.setBook(book);
            binding.postLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    router.setPostDetailFragment(R.id.container,new BookDetailFragment(book));
                }
            });
        }

    }
}
