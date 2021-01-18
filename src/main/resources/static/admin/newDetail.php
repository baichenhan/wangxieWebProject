<?php
    header('Content-Type:application/json');
    $array = [
            'id'            => 1,
            'username'       => 'juan1',
            'school_id'      => '11122233',
            'sex'            => 1,
            'email'          => '449097632@qq.com',
            'QQ'             => '449097632',
            'tel'            => '15603334937',
            'create_ip'        => '127.0.0.1',
            'status'         => 1,
            'create_time'    => date('Y-m-d H:i:s')
    ];

    echo json_encode($array);
