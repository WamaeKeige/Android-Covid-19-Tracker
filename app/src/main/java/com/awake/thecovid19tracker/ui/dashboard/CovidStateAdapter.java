package com.awake.thecovid19tracker.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awake.thecovid19tracker.R;


import java.util.ArrayList;
import java.util.List;

public class CovidStateAdapter extends RecyclerView.Adapter<CovidStateAdapter.ViewHolder> implements Filterable {
    private List<CovidState> covidStates;
    private List<CovidState> covidStatesFull;

    private Context context;
    @Override
    public Filter getFilter() {
        return covidStatesFilter;
    }
    private Filter covidStatesFilter = new Filter(){
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<CovidState> filteredCovidState = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredCovidState.addAll(covidStatesFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (CovidState itemCovidState : covidStatesFull) {
                    if (itemCovidState.getmState().toLowerCase().contains(filterPattern)) {
                        filteredCovidState.add(itemCovidState);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredCovidState;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            covidStates.clear();
            covidStates.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public CovidStateAdapter(List<CovidState> covidStates, Context context) {
        this.covidStates = covidStates;
        this.context = context;
        covidStatesFull = new ArrayList<>(covidStates);
    }
    @NonNull
    @Override
    public CovidStateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.states, parent, false);
        return new CovidStateAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidStateAdapter.ViewHolder holder, int position) {
        CovidState covidState = covidStates.get(position);
        holder.tvTotalCases.setText(Integer.toString(covidState.getmCases()));
        holder.tvStateName.setText(covidState.getmState());
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTotalCases, tvStateName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTotalCases = itemView.findViewById(R.id.txtCases);
            tvStateName = itemView.findViewById(R.id.txtstate);

        }
    }
    @Override
    public int getItemCount() {
        return covidStates.size();
    }
}
