package com.asher.snapmailer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MailHistoryFragment extends Fragment {

    public MailHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mail_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.mailHistoryRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        List<MailHistoryModel> list = new ArrayList<>();

        list.add(new MailHistoryModel("Rana Akshat", "09:16 pm", R.drawable.ic_baseline_person_24, true));
        list.add(new MailHistoryModel("Rana Akshat", "09:16 pm", R.drawable.ic_baseline_person_24, true));
        list.add(new MailHistoryModel("Rana Akshat", "09:16 pm", R.drawable.ic_baseline_person_24, true));
        list.add(new MailHistoryModel("Rana Akshat", "09:16 pm", R.drawable.ic_baseline_person_24, true));
        list.add(new MailHistoryModel("Rana Akshat", "09:16 pm", R.drawable.ic_baseline_person_24, true));
        list.add(new MailHistoryModel("Rana Akshat", "09:16 pm", R.drawable.ic_baseline_person_24, true));
        list.add(new MailHistoryModel("Rana Akshat", "09:16 pm", R.drawable.ic_baseline_person_24, true));
        list.add(new MailHistoryModel("Rana Akshat", "09:16 pm", R.drawable.ic_baseline_person_24, true));
        list.add(new MailHistoryModel("Rana Akshat", "09:16 pm", R.drawable.ic_baseline_person_24, true));
        list.add(new MailHistoryModel("Rana Akshat", "09:16 pm", R.drawable.ic_baseline_person_24, true));
        list.add(new MailHistoryModel("Rana Akshat", "09:16 pm", R.drawable.ic_baseline_person_24, true));
        list.add(new MailHistoryModel("Rana Akshat", "09:16 pm", R.drawable.ic_baseline_person_24, true));



        MailHistoryAdapter adapter = new MailHistoryAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}