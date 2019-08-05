import 'package:flutter/material.dart';

void main(){
  runApp(new application());
}

class application extends StatefulWidget {
  @override
  _applicationState createState() => _applicationState();
}

class _applicationState extends State<application> {
  List<int> items = new List();

  @override
  void initState() {
    // TODO: implement initState
    for(int i=0; i<50; i++){
      items.add(i);
    }
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'Dummy Application',
      home: new Scaffold(
        appBar: new AppBar(title: new Text('List Widget'),),
        body: new ListView.builder(
            itemCount: items.length,
            itemBuilder: (BuildContext context, int index){
              return new ListTile(
                title: new Text('item no : $index'),
                trailing: new Icon(Icons.arrow_forward),
              );
            }
        ),
      )
    );
  }
}

