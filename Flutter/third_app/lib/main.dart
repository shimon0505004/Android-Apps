import 'package:flutter/material.dart';

void main(){
  runApp(new application());
}

class application extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: "Shimon App",
      home: new Scaffold(
        appBar: new AppBar(title: new Text('Row & Column'),),
        body: new ListView(
          children: <Widget>[
            new ListTile(
              title: new Text('item 1'),
              trailing: new Icon(Icons.arrow_forward),
            ),
            new ListTile(
              title: new Text('item 2'),
              trailing: new Icon(Icons.arrow_forward),
            ),
            new ListTile(
              title: new Text('item 3'),
              trailing: new Icon(Icons.arrow_forward),
            ),
            new ListTile(
              title: new Text('item 4'),
              trailing: new Icon(Icons.arrow_forward),
            ),
            new ListTile(
              title: new Text('item 5'),
              trailing: new Icon(Icons.arrow_forward),
            ),
          ],
        )
      )
    );
  }
}
