package com.shawonarefin.findrepo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.AccessControlContext

class SearchResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

    }

    override fun onResume() {
        super.onResume()

        val searchTerm = intent.getStringExtra("searchTerm")

        val retriever = GitHubRetriever()
        val callback = object : Callback<GitHubSearchResult>{

            override fun onResponse(call: Call<GitHubSearchResult>, response: Response<GitHubSearchResult>) {
                val searchResult = response?.body()
                if(searchResult != null){
                    for(repo in searchResult!!.items){
                        println(repo.html_url)
                    }

                    val listView = findViewById<ListView>(R.id.searchResultListView)
                    val adapter = GitHubRepoAdapter(this@SearchResultActivity,android.R.layout.simple_list_item_1,searchResult!!.items)
                    listView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<GitHubSearchResult>, t: Throwable) {
                println("It's not working")
            }
        }

        retriever.searchRepos(callback, searchTerm)
    }
}


class GitHubRepoAdapter(context: Context? , resource: Int, objects: List<Repo>?)
    : ArrayAdapter<Repo>(context, resource, objects){
    override fun getCount(): Int {
        return super.getCount()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val repoView = inflator.inflate(android.R.layout.simple_list_item_1,parent,false) as TextView

        val repoItem = getItem(position)
        repoView.text = repoItem.full_name
        return repoView
    }
}