package com.apps.szpansky.gitsearch.mainActivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.szpansky.gitsearch.R;
import com.apps.szpansky.gitsearch.dataStructure.DataStructure;
import com.apps.szpansky.gitsearch.dataStructure.Repo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {

    List<Repo> reposList;
    Context context;
    RepoAdapterInterface repoAdapterInterface;

    public void setRepoAdapterInterface(RepoAdapterInterface repoAdapterInterface) {
        this.repoAdapterInterface = repoAdapterInterface;
    }

    RequestOptions requestOptions = new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(20));


    public ReposAdapter(List<? extends DataStructure> repoList) {
        this.reposList = (List<Repo>) repoList;
    }


    public interface RepoAdapterInterface {
        void onItemClick(Repo repo);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repo_name)
        TextView name;
        @BindView(R.id.owner_avatar)
        ImageView ownerAvatar;
        @BindView(R.id.owner_stars_number)
        TextView repoStars;
        @BindView(R.id.programming_language)
        TextView programmingLanguage;

        @OnClick(R.id.repo_layout)
        public void onItemClick() {
            repoAdapterInterface.onItemClick(reposList.get(getAdapterPosition()));
        }


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        void bind(Repo repo) {
            name.setText(repo.getName());
            name.setSelected(true);
            repoStars.setText(repo.getStargazers_count());
            repoStars.setSelected(true);
            programmingLanguage.setText(repo.getLanguage());
            programmingLanguage.setSelected(true);

            if (repo.getOwner() != null) {
                if (repo.getOwner().getAvatarUrl().contains("https")) {
                    Glide.with(context)
                            .load(repo.getOwner().getAvatarUrl())
                            .apply(requestOptions)
                            .into(ownerAvatar);
                }
            }
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(reposList.get(position));
    }


    @Override
    public long getItemId(int position) {
        return reposList.get(position).getId();
    }


    @Override
    public int getItemCount() {
        return reposList.size();
    }
}
