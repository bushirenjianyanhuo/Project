package com.example.project.ui.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.project.R;
import com.example.project.contactCenter.ContactDirectory;
import com.example.project.contactCenter.Equipment;
import com.example.project.contactCenter.FragmentAdapter;
import com.example.project.contactCenter.GroupChatDirectory;
import com.example.project.contactCenter.LuckyStar;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment implements View.OnClickListener{
    ViewPager2 viewPager2;

    private LinearLayout news, contacts, square, rect;
    private ContactsViewModel contactsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contactsViewModel = new ViewModelProvider(this).get(ContactsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contacts, container, false);

         viewPager2 = root.findViewById(R.id.vPager);
        List<Fragment> fragments1 = new ArrayList<>();
        fragments1.add(ContactDirectory.newInstance("微信聊天", "微信聊天"));
        fragments1.add(GroupChatDirectory.newInstance("微信聊天", "微信聊天"));
        fragments1.add(Equipment.newInstance("微信聊天", "微信聊天"));
        fragments1.add(LuckyStar.newInstance("微信聊天", "微信聊天"));
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), getLifecycle(), fragments1);
        viewPager2.setAdapter(fragmentAdapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        news = root.findViewById(R.id.news);
        news.setOnClickListener(this);
        contacts = root.findViewById(R.id.contacts);
        contacts.setOnClickListener(this);
        square = root.findViewById(R.id.square);
        square.setOnClickListener(this);
        rect = root.findViewById(R.id.rect);
        rect.setOnClickListener(this);


        return root;

    }

    private void changeTab(int position) {
        switch (position){
            case R.id.news:
                viewPager2.setCurrentItem(0);
            case 0:
                news.setSelected(true);
                break;
            case R.id.contacts:
                viewPager2.setCurrentItem(1);
            case 1:
                contacts.setSelected(true);
                break;
            case R.id.square:
                viewPager2.setCurrentItem(2);
            case 2:
                square.setSelected(true);
                break;
            case R.id.rect:
                viewPager2.setCurrentItem(3);
            case 3:
                rect.setSelected(true);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        changeTab(v.getId());

    }
}
