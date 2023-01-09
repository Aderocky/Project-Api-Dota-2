package com.example.projectapi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectapi.adapter.leaguesViewAdapter;
import com.example.projectapi.api.reteroserper;
import com.example.projectapi.api.apiRqstData;
import com.example.projectapi.models.leagueidd;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link leaguesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class leaguesFragment extends Fragment {

    private RecyclerView rvleagues;
    private List<leagueidd> listleagues;
    private leaguesViewAdapter adapterleagues;
    private ProgressBar pbquote;
    private TextView tvmohon;
    private LinearLayoutManager linearLayoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public leaguesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServantsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static leaguesFragment newInstance(String param1, String param2) {
        leaguesFragment fragment = new leaguesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leagues, container, false);

        rvleagues = view.findViewById(R.id.rv_leagues);
        pbquote = view.findViewById(R.id.pb_quote);
        tvmohon = view.findViewById(R.id.tv_mohon);

        linearLayoutManager = new LinearLayoutManager(view.getContext());
        //rvServants.setHasFixedSize(true);
        rvleagues.setLayoutManager(linearLayoutManager);
        retrieveQuote();

        return view;
    }

    private void retrieveQuote(){
        pbquote.setVisibility(View.VISIBLE);
        tvmohon.setVisibility(View.VISIBLE);

        apiRqstData ardData = reteroserper.getRetrofit().create(apiRqstData.class);
        Call<List<leagueidd>> retrieveProcess = ardData.getLeagues();
        retrieveProcess.enqueue(new Callback<List<leagueidd>>() {
            @Override
            public void onResponse(Call<List<leagueidd>> call, Response<List<leagueidd>> response) {
                listleagues = response.body();
                adapterleagues = new leaguesViewAdapter(listleagues);
                rvleagues.setAdapter(adapterleagues);
                pbquote.setVisibility(View.INVISIBLE);
                tvmohon.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<leagueidd>> call, Throwable t) {

                Log.d("cek",t.getMessage());
                pbquote.setVisibility(View.INVISIBLE);
                tvmohon.setVisibility(View.INVISIBLE);
            }
        });
    }

}