(function() {
    'use strict';
    angular
        .module('gatewayApp')
        .factory('Post', Post);

    Post.$inject = ['$resource'];

    function Post ($resource) {
        var resourceUrl =  'bussiness/' + 'api/posts/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
