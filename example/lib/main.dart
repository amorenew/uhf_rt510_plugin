import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:uhf_plugin/uhf_plugin.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';
  bool _isStarted = false;
  bool _isEmptyTags = false;
  bool _isConnected = false;

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    String platformVersion;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      platformVersion = await UhfPlugin.platformVersion;
    } on PlatformException {
      platformVersion = 'Failed to get platform version.';
    }
    UhfPlugin.connectedStatusStream
        .receiveBroadcastStream()
        .listen(updateIsConnected);
    UhfPlugin.tagsStatusStream.receiveBroadcastStream().listen(updateTags);

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _platformVersion = platformVersion;
    });
  }

  List<String> _data = ['--'];
  void updateTags(dynamic result) {
    setState(() {
      _data.add('$result');
    });
  }

  void updateIsConnected(dynamic isConnected) {
    //setState(() {
    _isConnected = isConnected;
    //});
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Column(
            children: <Widget>[
              Text('Running on: $_platformVersion'),
              RaisedButton(
                  child: Text('Call connect'),
                  onPressed: () async {
                    await UhfPlugin.connect;
                  }),
              RaisedButton(
                  child: Text('Call is Connected'),
                  onPressed: () async {
                    bool isConnected = await UhfPlugin.isConnected;
                    setState(() {
                      this._isConnected = isConnected;
                    });
                  }),
              RaisedButton(
                  child: Text('Call isStarted'),
                  onPressed: () async {
                    bool isStarted = await UhfPlugin.isStarted;
                    setState(() {
                      this._isStarted = isStarted;
                    });
                  }),
              Text('UHF Reader isStarted:$_isStarted'),
              RaisedButton(
                  child: Text('Call Start'),
                  onPressed: () async {
                    await UhfPlugin.start;
                  }),
              RaisedButton(
                  child: Text('Call Stop'),
                  onPressed: () async {
                    await UhfPlugin.stop;
                  }),
              RaisedButton(
                  child: Text('Call Close'),
                  onPressed: () async {
                    await UhfPlugin.close;
                  }),
              RaisedButton(
                  child: Text('Call Clear Data'),
                  onPressed: () async {
                    await UhfPlugin.clearData;
                  }),
              RaisedButton(
                  child: Text('Call is Empty Tags'),
                  onPressed: () async {
                    bool isEmptyTags = await UhfPlugin.isEmptyTags;
                    setState(() {
                      this._isEmptyTags = isEmptyTags;
                    });
                  }),
              Text('UHF Reader isEmptyTags:$_isEmptyTags'),
              Text('UHF Reader isConnected:$_isConnected'),
              ..._data.map((text) => Text('Status - UHF Tags: $text')),
            ],
          ),
        ),
      ),
    );
  }
}
