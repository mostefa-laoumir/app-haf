package com.mostefalmr.hafezni

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    inner class AnimalAdapter: BaseAdapter {
        var animalList = ArrayList<ModuleModel>()
        var context: Context?= null
        constructor(context: Context, animalList :ArrayList<ModuleModel>):super(){
            this.animalList=animalList
            this.context = context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = animalList[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            if(animal.isKiller==true){
                var myView = inflater.inflate(R.layout.animal_killer_ticket,null)
                myView.=animal.name!!
                myView.ivAnimal.setImageResource(animal.image!!)
                myView.tvDescription.text = animal.des!!
                myView.ivAnimal.setOnClickListener{
                    val intent = Intent(context, Main2Activity::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.image!!)
                    context!!.startActivity(intent)
                }
                myView.ivDel.setOnClickListener{
                    delete(position)
                }

                return myView

            }else{
                var myView = inflater.inflate(R.layout.animal_ticket,null)
                myView.tvNamee.text=animal.name!!
                myView.ivAnimal.setImageResource(animal.image!!)
                myView.tvDescription.text = animal.des!!
                myView.ivAnimal.setOnClickListener{
                    val intent = Intent(context, Main2Activity::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.image!!)
                    context!!.startActivity(intent)

                }
                myView.ivDel.setOnClickListener {
                    delete(position)
                }
                return myView
            }

        }

        override fun getItem(position: Int): Any {
            return animalList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return animalList.size
        }

    }

}